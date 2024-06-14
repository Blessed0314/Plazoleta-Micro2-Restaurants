package com.pragma.microservice2.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RestaurantToOrderResponse {
    private final String name;
    private final String nit;
    private final String address;
    private final String phone;
    private final String logo;
}
