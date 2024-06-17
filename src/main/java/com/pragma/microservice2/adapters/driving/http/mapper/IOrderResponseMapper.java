package com.pragma.microservice2.adapters.driving.http.mapper;

import com.pragma.microservice2.adapters.driving.http.dto.response.OrderItemResponse;
import com.pragma.microservice2.adapters.driving.http.dto.response.OrderToClientResponse;
import com.pragma.microservice2.adapters.driving.http.dto.response.OrderToEmployeeResponse;
import com.pragma.microservice2.domain.model.Order;
import com.pragma.microservice2.domain.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderResponseMapper {
    @Mapping(target = "orderItems", source = "order.orderItems")
    OrderToClientResponse toOrderResponse(Order order);
    List<OrderToEmployeeResponse> toOrderResponseList (List<Order> orders);

    List<OrderItemResponse> toOrderItemResponseList(List<OrderItem> orderItems);
    OrderItemResponse toOrderItemResponse(OrderItem orderItem);
}
