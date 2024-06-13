package com.pragma.microservice2.adapters.driving.http.mapper;

import com.pragma.microservice2.adapters.driving.http.dto.response.DishResponse;
import com.pragma.microservice2.domain.model.Dish;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDishResponseMapper {
    DishResponse toDishResponse(Dish dish);
}
