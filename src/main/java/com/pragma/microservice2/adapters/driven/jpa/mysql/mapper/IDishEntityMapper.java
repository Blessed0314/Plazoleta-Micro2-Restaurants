package com.pragma.microservice2.adapters.driven.jpa.mysql.mapper;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.microservice2.domain.model.Dish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDishEntityMapper {
    DishEntity toEntity(Dish dish);
    Dish toModel(DishEntity entity);
    List<Dish> toModelList(List<DishEntity> dishEntities);
}
