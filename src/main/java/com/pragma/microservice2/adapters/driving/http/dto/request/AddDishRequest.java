package com.pragma.microservice2.adapters.driving.http.dto.request;

import com.pragma.microservice2.adapters.driving.http.util.MessageConstants;
import com.pragma.microservice2.domain.model.Restaurant;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;

@AllArgsConstructor
@Getter
public class AddDishRequest {

    @NotBlank(message = MessageConstants.FIELD_NAME_NULL_MESSAGE)
    private final String name;

    @NotNull(message = MessageConstants.FIELD_PRICE_NULL_MESSAGE)
    @DecimalMin(value = "0.0", inclusive = false, message = MessageConstants.FIELD_PRICE_NEGATIVE_MESSAGE)
    private final Double price;

    @NotBlank(message = MessageConstants.FIELD_DESCRIPTION_NULL_MESSAGE)
    private final String description;

    @NotBlank(message = MessageConstants.FIELD_IMAGE_NULL_MESSAGE)
    @URL(message = MessageConstants.FIELD_IMAGE_NOT_URL_MESSAGE)
    private final String image;

    @NotBlank(message = MessageConstants.FIELD_CATEGORY_NULL_MESSAGE)
    private final String category;

    @NotNull(message = MessageConstants.FIELD_RESTAURANT_NULL_MESSAGE)
    private final Restaurant restaurant;
}
