package com.pragma.microservice2.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DishResponse {
    private final String name;
    private final double price;
    private final String description;
    private final String image;
    private final String category;
}
