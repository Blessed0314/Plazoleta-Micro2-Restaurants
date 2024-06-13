package com.pragma.microservice2.domain.api.usecase;

import com.pragma.microservice2.domain.api.IDishServicePort;
import com.pragma.microservice2.domain.model.Dish;
import com.pragma.microservice2.domain.spi.IDishPersistencePort;

import java.util.List;

public class DishUseCase implements IDishServicePort {

    private final IDishPersistencePort dishPersistencePort;

    public DishUseCase(IDishPersistencePort dishPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
    }

    @Override
    public void saveDish(Dish dish) {
        dishPersistencePort.saveDish(dish);
    }

    @Override
    public Dish updateDish(Dish dish) {
        return dishPersistencePort.updateDish(dish);
    }

    @Override
    public void patchIsActiveDish(Long id) {
        dishPersistencePort.patchIsActiveDish(id);
    }

    @Override
    public List<Dish> getAllDishes(Integer page, Integer size, String category) {
        return dishPersistencePort.getAllDishes(page, size, category);
    }
}
