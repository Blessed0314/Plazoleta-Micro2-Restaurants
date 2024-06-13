package com.pragma.microservice2.adapters.driving.http.dto.request;

import com.pragma.microservice2.adapters.driving.http.util.MessageConstants;
import com.pragma.microservice2.domain.model.Restaurant;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateDishRequest {

    @NotNull(message = MessageConstants.FIELD_ID_NULL_MESSAGE)
    private final Long id;

    @DecimalMin(value = "0.0", inclusive = false, message = MessageConstants.FIELD_PRICE_NEGATIVE_MESSAGE)
    private final Double price;

    private final String description;

    @NotNull(message = MessageConstants.FIELD_RESTAURANT_NULL_MESSAGE)
    private final Restaurant restaurant;
}
