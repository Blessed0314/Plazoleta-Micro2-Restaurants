package com.pragma.microservice2.adapters.driving.http.mapper;

import com.pragma.microservice2.adapters.driving.http.dto.request.AddDishRequest;
import com.pragma.microservice2.adapters.driving.http.dto.request.UpdateDishRequest;
import com.pragma.microservice2.domain.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IDishRequestMapper {
    @Mapping(target = "id", ignore = true)
    Dish addRequestToDish(AddDishRequest addDishRequest);

    Dish updateRequestToDish(UpdateDishRequest updateDishRequest);
}
