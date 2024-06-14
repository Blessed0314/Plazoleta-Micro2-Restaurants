package com.pragma.microservice2.adapters.driven.jpa.mysql.mapper;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.OrderItemEntity;
import com.pragma.microservice2.domain.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderItemEntityMapper {

    @Mapping(target = "order", ignore = true)
    OrderItemEntity toEntity(OrderItem orderItem);

    OrderItem toModel(OrderItemEntity entity);

    List<OrderItem> orderItemEntityListToOrderItemList(List<OrderItemEntity> entities);

    List<OrderItemEntity> orderItemListToOrderItemEntityList(List<OrderItem> orderItems);
}
