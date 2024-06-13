package com.pragma.microservice2.adapters.driving.http.dto.request;

import com.pragma.microservice2.adapters.driving.http.util.MessageConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;


@AllArgsConstructor
@Getter
public class AddRestaurantRequest {

    @NotBlank(message = MessageConstants.FIELD_NIT_NULL_MESSAGE)
    @Pattern(regexp = "^\\d+$", message = MessageConstants.FIELD_NIT_ONLY_NUMBERS_MESSAGE)
    private final String nit;

    @NotBlank(message = MessageConstants.FIELD_NAME_NULL_MESSAGE)
    @Pattern(regexp = "^(?=.*[a-zA-Z])[a-zA-Z0-9 ]+$", message = MessageConstants.FIELD_NAME_ONLY_NUMBERS_MESSAGE)
    private final String name;

    @NotBlank(message = MessageConstants.FIELD_ADDRESS_NULL_MESSAGE)
    private final String address;

    @NotBlank(message = MessageConstants.FIELD_PHONE_NULL_MESSAGE)
    @Pattern(regexp = "^(\\+)?\\d{1,13}$", message = MessageConstants.FIELD_PHONE_ONLY_NUMBERS_MESSAGE)
    private final String phone;

    @NotBlank(message = MessageConstants.FIELD_LOGO_NULL_MESSAGE)
    @URL(message = MessageConstants.FIELD_LOGO_NOT_URL_MESSAGE)
    private final String logo;

}
