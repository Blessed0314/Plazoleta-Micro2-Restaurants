package com.pragma.microservice2.adapters.driving.http.mapper;

import com.pragma.microservice2.adapters.driving.http.dto.response.OrderItemResponse;
import com.pragma.microservice2.adapters.driving.http.dto.response.OrderResponse;
import com.pragma.microservice2.domain.model.Order;
import com.pragma.microservice2.domain.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderResponseMapper {
    @Mapping(target = "orderItems", source = "order.orderItems")
    OrderResponse toOrderResponse(Order order);

    List<OrderItemResponse> toOrderItemResponseList(List<OrderItem> orderItems);
    OrderItemResponse toOrderItemResponse(OrderItem orderItem);
}
