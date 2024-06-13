package com.pragma.microservice2.domain.api.usecase;

import com.pragma.microservice2.domain.api.IRestaurantServicePort;
import com.pragma.microservice2.domain.model.Restaurant;
import com.pragma.microservice2.domain.spi.IRestaurantPersistencePort;

public class RestaurantUseCase implements IRestaurantServicePort {

    private final IRestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantPersistencePort.saveRestaurant(restaurant);
    }
}
