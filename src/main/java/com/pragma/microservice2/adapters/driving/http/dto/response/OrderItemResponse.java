package com.pragma.microservice2.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderItemResponse {
    private final DishToOrderItemResponse dish;
    private final int quantity;
}
