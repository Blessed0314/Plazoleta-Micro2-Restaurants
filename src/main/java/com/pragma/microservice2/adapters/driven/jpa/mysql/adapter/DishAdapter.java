package com.pragma.microservice2.adapters.driven.jpa.mysql.adapter;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.pragma.microservice2.adapters.driven.jpa.mysql.exception.DishNameAlreadyExistsException;
import com.pragma.microservice2.adapters.driven.jpa.mysql.exception.RestaurantNotFoundException;
import com.pragma.microservice2.adapters.driven.jpa.mysql.exception.WrongOwnerException;
import com.pragma.microservice2.adapters.driven.jpa.mysql.mapper.IDishEntityMapper;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IDishRepository;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IRestaurantRepository;
import com.pragma.microservice2.adapters.security.CustomUserDetail;
import com.pragma.microservice2.domain.model.Dish;
import com.pragma.microservice2.domain.spi.IDishPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        RestaurantEntity restaurantEntity = restaurantRepository.findById(dish.getRestaurant().getNit()).orElseThrow(RestaurantNotFoundException::new);
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetail userDetails) {
            if(!restaurantEntity.getDniOwner().equals(userDetails.getDni())) {
                throw new WrongOwnerException();
            }
        }

        Optional<DishEntity> optional = dishRepository.findByRestaurant_Name(restaurantEntity.getName());
        if(optional.isPresent()) {
            throw new DishNameAlreadyExistsException();
        }

        dishRepository.save(dishEntityMapper.toEntity(dish));
    }
}
