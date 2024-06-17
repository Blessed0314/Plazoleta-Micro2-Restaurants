package com.pragma.microservice2.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class OrderToEmployeeResponse {
    private final Long id;
    private final String dniClient;
    private final RestaurantToOrderResponse restaurant;
    private final List<OrderItemResponse> orderItems;
    private final String status;
}
