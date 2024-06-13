package com.pragma.microservice2.adapters.driving.http.mapper;

import com.pragma.microservice2.adapters.driving.http.dto.response.DishResponse;
import com.pragma.microservice2.domain.model.Dish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDishResponseMapper {
    DishResponse toDishResponse(Dish dish);
    List<DishResponse> toDishResponseList(List<Dish> dishes);
}
