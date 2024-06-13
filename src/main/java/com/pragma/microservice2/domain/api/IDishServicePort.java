package com.pragma.microservice2.domain.api;

import com.pragma.microservice2.domain.model.Dish;

public interface IDishServicePort {
    void saveDish(Dish dish);
}
