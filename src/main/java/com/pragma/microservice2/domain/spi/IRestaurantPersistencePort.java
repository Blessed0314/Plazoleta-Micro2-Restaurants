package com.pragma.microservice2.domain.spi;

import com.pragma.microservice2.domain.model.Restaurant;

public interface IRestaurantPersistencePort {
    void saveRestaurant(Restaurant restaurant);
}
