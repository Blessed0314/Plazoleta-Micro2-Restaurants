package com.pragma.microservice2.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RestaurantResponse {
    private final String name;
    private final String logo;
}
