package com.pragma.microservice2.adapters.driving.http.dto.request;

import com.pragma.microservice2.adapters.driving.http.util.MessageConstants;
import com.pragma.microservice2.domain.model.Dish;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddOrderItemRequest {

    @NotNull(message = MessageConstants.FIELD_DISH_NULL_MESSAGE)
    private final Dish dish;

    @NotNull(message = MessageConstants.FIELD_QUANTITY_NULL_MESSAGE)
    @Positive(message = MessageConstants.FIELD_QUANTITY_NEGATIVE_MESSAGE)
    private final int quantity;

}
