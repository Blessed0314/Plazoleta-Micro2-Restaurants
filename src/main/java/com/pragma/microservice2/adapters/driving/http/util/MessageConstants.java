package com.pragma.microservice2.adapters.driving.http.util;

public class MessageConstants {
    private MessageConstants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String FIELD_NIT_NULL_MESSAGE = "Field 'NIT' cannot be null";
    public static final String FIELD_NIT_ONLY_NUMBERS_MESSAGE = "Field 'NIT' can only have numbers";
    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' cannot be null";
    public static final String FIELD_NAME_ONLY_NUMBERS_MESSAGE = "Field 'name' can't only have numbers";
    public static final String FIELD_ADDRESS_NULL_MESSAGE = "Field 'address' cannot be null";
    public static final String FIELD_PHONE_NULL_MESSAGE = "Field 'phone' cannot be null";
    public static final String FIELD_PHONE_ONLY_NUMBERS_MESSAGE = "Field 'phone' can only have numbers or '+' before the number";
    public static final String FIELD_LOGO_NULL_MESSAGE = "Field 'logo' cannot be null";
    public static final String FIELD_LOGO_NOT_URL_MESSAGE = "Field 'logo' is not a valid URL";
}
