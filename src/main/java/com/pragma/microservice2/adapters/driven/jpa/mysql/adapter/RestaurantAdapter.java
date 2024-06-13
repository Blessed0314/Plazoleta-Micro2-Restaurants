package com.pragma.microservice2.adapters.driven.jpa.mysql.adapter;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.pragma.microservice2.adapters.driven.jpa.mysql.exception.NitAlreadyExistsException;
import com.pragma.microservice2.adapters.driven.jpa.mysql.exception.RestaurantByNameAlreadyExistsException;
import com.pragma.microservice2.adapters.driven.jpa.mysql.mapper.IRestaurantEntityMapper;
import com.pragma.microservice2.adapters.driven.jpa.mysql.repository.IRestaurantRepository;
import com.pragma.microservice2.adapters.security.CustomUserDetail;
import com.pragma.microservice2.domain.model.Restaurant;
import com.pragma.microservice2.domain.spi.IRestaurantPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RequiredArgsConstructor
public class RestaurantAdapter implements IRestaurantPersistencePort {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    @Override
    public void saveRestaurant(Restaurant restaurant) {

        if(restaurantRepository.existsById(restaurant.getNit())){
            throw new NitAlreadyExistsException();
        }
        if(restaurantRepository.existsByName(restaurant.getName())){
            throw new RestaurantByNameAlreadyExistsException();
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        RestaurantEntity restaurantEntity = restaurantEntityMapper.toEntity(restaurant);
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetail userDetails) {
            restaurantEntity.setDniOwner(userDetails.getDni());
            restaurantRepository.save(restaurantEntity);
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants(Integer page, Integer size, boolean ascendingFlag) {
        Sort sort = ascendingFlag ? Sort.by(Sort.Direction.ASC, "name") : Sort.by(Sort.Direction.DESC, "name");
        Pageable pagination = PageRequest.of(page, size, sort);
        List<RestaurantEntity> restaurants = restaurantRepository.findAll(pagination).getContent();
        return restaurantEntityMapper.toModelList(restaurants);
    }
}
