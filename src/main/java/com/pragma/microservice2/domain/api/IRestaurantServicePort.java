package com.pragma.microservice2.domain.api;

import com.pragma.microservice2.domain.model.Restaurant;

import java.util.List;

public interface IRestaurantServicePort {
    void saveRestaurant(Restaurant restaurant);
    List<Restaurant> getAllRestaurants(Integer page, Integer size, boolean ascendingFlag);
}
