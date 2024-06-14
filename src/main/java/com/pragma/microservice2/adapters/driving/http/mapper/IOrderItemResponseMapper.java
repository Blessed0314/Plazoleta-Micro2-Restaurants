package com.pragma.microservice2.adapters.driving.http.mapper;

import com.pragma.microservice2.adapters.driving.http.dto.response.OrderItemResponse;
import com.pragma.microservice2.domain.model.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderItemResponseMapper {
    OrderItemResponse toOrderItemResponse(OrderItem orderItem);
    List<OrderItemResponse> toOrderItemResponseList(List<OrderItem> orderItems);
}
