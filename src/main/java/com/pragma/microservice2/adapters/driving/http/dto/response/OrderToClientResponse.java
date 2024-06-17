package com.pragma.microservice2.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class OrderToClientResponse {
    private final RestaurantToOrderResponse restaurant;
    private final List<OrderItemResponse> orderItems;
}
