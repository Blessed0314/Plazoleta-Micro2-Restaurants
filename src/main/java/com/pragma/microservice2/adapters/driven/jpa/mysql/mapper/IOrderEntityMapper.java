package com.pragma.microservice2.adapters.driven.jpa.mysql.mapper;

import com.pragma.microservice2.adapters.driven.jpa.mysql.entity.OrderEntity;
import com.pragma.microservice2.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = IOrderItemEntityMapper.class)
public interface IOrderEntityMapper {

    @Mapping(target = "orderItems", ignore = true)
    OrderEntity toEntity(Order order);

    Order toModel(OrderEntity orderEntity);

    List<Order> toModelList(List<OrderEntity> orderEntities);
}
