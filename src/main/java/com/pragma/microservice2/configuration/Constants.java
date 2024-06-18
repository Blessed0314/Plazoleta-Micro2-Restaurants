package com.pragma.microservice2.configuration;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String ROLE_PERMISSIONS_EXCEPTION_MESSAGE = "You are not authorized to access this service";
    public static final String RESTAURANT_BY_NAME_ALREADY_EXISTS_EXCEPTION_MESSAGE = "This restaurant's name already exists";
    public static final String NIT_ALREADY_EXISTS_EXCEPTION_MESSAGE = "This restaurant's nit already exists";
    public static final String DISH_BY_NAME_ALREADY_EXISTS_EXCEPTION_MESSAGE = "This dish's name already exists";
    public static final String RESTAURANT_NOT_FOUND_EXCEPTION_MESSAGE = "This restaurant not found";
    public static final String WRONG_OWNER_EXCEPTION_MESSAGE = "You are not the owner of this restaurant";
    public static final String WRONG_ORDER_EXCEPTION_MESSAGE = "The order is not from the restaurant where you are an employee";
    public static final String HAVE_ORDER_IN_PROGRESS_EXCEPTION_MESSAGE = "You already have an order in progress";
    public static final String ORDER_NOT_FOUND_EXCEPTION_MESSAGE = "This order not found";
    public static final String DISH_NOT_FOUND_EXCEPTION_MESSAGE = "This dish not found";
}
