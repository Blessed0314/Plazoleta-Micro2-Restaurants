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
    public static final String FIELD_PRICE_NULL_MESSAGE = "Field 'price' cannot be null";
    public static final String FIELD_PRICE_NEGATIVE_MESSAGE = "Field 'price' cannot be negative";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' cannot be null";
    public static final String FIELD_IMAGE_NULL_MESSAGE = "Field 'image' cannot be null";
    public static final String FIELD_IMAGE_NOT_URL_MESSAGE = "Field 'image' is not a valid URL";
    public static final String FIELD_CATEGORY_NULL_MESSAGE = "Field 'category' cannot be null";
    public static final String FIELD_RESTAURANT_NULL_MESSAGE = "Field 'restaurant' cannot be null";
    public static final String FIELD_ID_NULL_MESSAGE = "Field 'id' cannot be null";
    public static final String FIELD_DISH_NULL_MESSAGE = "Field 'dish' cannot be null";
    public static final String FIELD_QUANTITY_NULL_MESSAGE = "Field 'quantity' cannot be null";
    public static final String FIELD_QUANTITY_NEGATIVE_MESSAGE = "Field 'quantity' cannot be negative";
    public static final String FIELD_ORDER_ITEMS_EMPTY_MESSAGE = "Field 'orderItems' cannot be empty";
}
