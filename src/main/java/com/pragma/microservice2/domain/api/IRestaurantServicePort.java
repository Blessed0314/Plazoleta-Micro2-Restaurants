package com.pragma.microservice2.domain.api;

import com.pragma.microservice2.domain.model.Restaurant;

public interface IRestaurantServicePort {
    void saveRestaurant(Restaurant restaurant);
}
