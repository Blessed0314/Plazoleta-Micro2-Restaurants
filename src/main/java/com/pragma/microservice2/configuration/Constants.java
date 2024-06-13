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
}
