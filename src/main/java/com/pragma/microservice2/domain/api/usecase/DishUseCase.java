package com.pragma.microservice2.domain.api.usecase;

import com.pragma.microservice2.domain.api.IDishServicePort;
import com.pragma.microservice2.domain.model.Dish;
import com.pragma.microservice2.domain.spi.IDishPersistencePort;

public class DishUseCase implements IDishServicePort {

    private final IDishPersistencePort dishPersistencePort;

    public DishUseCase(IDishPersistencePort dishPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
    }

    @Override
    public void saveDish(Dish dish) {
        dishPersistencePort.saveDish(dish);
    }
}
