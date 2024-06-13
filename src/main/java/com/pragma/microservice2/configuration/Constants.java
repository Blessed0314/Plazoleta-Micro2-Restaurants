package com.pragma.microservice2.configuration;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String ROLE_PERMISSIONS_EXCEPTION_MESSAGE = "You are not authorized to access this service";
    public static final String RESTAURANT_BY_NAME_ALREADY_EXISTS_EXCEPTION_MESSAGE = "This restaurant's name already exists";
}
