package com.pragma.microservice2.adapters.driven.jpa.mysql.adapter;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.pragma.microservice2.adapters.driven.jpa.mysql.exception.*;
import com.pragma.microservice2.adapters.driven.jpa.mysql.mapper.IDishEntityMapper;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IDishRepository;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IRestaurantRepository;
import com.pragma.microservice2.adapters.security.CustomUserDetail;
import com.pragma.microservice2.domain.model.Dish;
import com.pragma.microservice2.domain.spi.IDishPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DishAdapter implements IDishPersistencePort {

    private final IDishRepository dishRepository;
    private final IRestaurantRepository restaurantRepository;
    private final IDishEntityMapper dishEntityMapper;

    @Override
    public void saveDish(Dish dish) {

        if(!restaurantRepository.existsById(dish.getRestaurant().getNit())) {
            throw new RestaurantNotFoundException();
        }

        if(validateOwner(dish.getRestaurant().getNit())) {
            throw new WrongOwnerException();
        }

        Optional<DishEntity> optional = dishRepository.findByRestaurant_Name(
                getRestaurantEntity(dish.getRestaurant().getNit()).getName());

        if(optional.isPresent()) {
            throw new DishNameAlreadyExistsException();
        }

        dishRepository.save(dishEntityMapper.toEntity(dish));
    }

    @Override
    public Dish updateDish(Dish dish) {
        if(dish.getPrice() == null && (dish.getDescription()==null || dish.getDescription().isEmpty())){
            throw new NullParametersException("'Price' or 'Description' must be provided");
        }

        if(validateOwner(dish.getRestaurant().getNit())){
            throw new WrongOwnerException();
        }

        DishEntity dishEntity = dishRepository.findById(dish.getId()).orElseThrow(DishNotFoundException::new);
        if(dish.getPrice() != null){
            dishEntity.setPrice(dish.getPrice());
        }
        if (dish.getDescription() != null && !dish.getDescription().isEmpty()) {
            dishEntity.setDescription(dish.getDescription());
        }
        return dishEntityMapper.toModel(dishRepository.save(dishEntity));
    }

    @Override
    public void patchIsActiveDish(Long id) {
        if(id == null){
            throw new NullParametersException("Id must be provided");
        }
        DishEntity dishEntity = dishRepository.findById(id).orElseThrow(DishNotFoundException::new);
        if(validateOwner(dishEntity.getRestaurant().getNit())){
            throw new WrongOwnerException();
        }
        dishEntity.setActive(!dishEntity.isActive());
    }

    @Override
    public List<Dish> getAllDishes(Integer page, Integer size, String category) {
        Pageable pageable = PageRequest.of(page, size);
        List<DishEntity> dishes = "all".equalsIgnoreCase(category)
                ? dishRepository.findAll(pageable).getContent()
                : dishRepository.findAllByCategory(category, pageable).getContent();
        return dishEntityMapper.toModelList(dishes);
    }

    private boolean validateOwner (String nit){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        RestaurantEntity restaurantEntity = getRestaurantEntity(nit);
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetail userDetails) {
            return !restaurantEntity.getDniOwner().equals(userDetails.getDni());
        }
        return false;
    }

    private RestaurantEntity getRestaurantEntity(String nit) {
        return restaurantRepository.findById(nit).orElseThrow(RestaurantNotFoundException::new);
    }
}
