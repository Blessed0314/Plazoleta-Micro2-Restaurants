package com.pragma.microservice2.adapters.driven.jpa.mysql.mapper;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.pragma.microservice2.domain.model.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRestaurantEntityMapper {
    RestaurantEntity toEntity(Restaurant restaurant);
    Restaurant toModel(RestaurantEntity entity);
}
