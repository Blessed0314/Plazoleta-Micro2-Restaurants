package com.pragma.microservice2.adapters.driving.http.dto.request;

import com.pragma.microservice2.adapters.driving.http.util.MessageConstants;
import com.pragma.microservice2.domain.model.Restaurant;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class AddOrderRequest {

    @NotNull(message = MessageConstants.FIELD_RESTAURANT_NULL_MESSAGE)
    private final Restaurant restaurant;

    @NotEmpty(message = MessageConstants.FIELD_ORDER_ITEMS_EMPTY_MESSAGE)
    @Valid
    private final List<AddOrderItemRequest> orderItems;
}

