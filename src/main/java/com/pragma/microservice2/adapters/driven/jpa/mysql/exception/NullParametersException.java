package com.pragma.microservice2.adapters.driven.jpa.mysql.exception;

public class NullParametersException extends RuntimeException{
    public NullParametersException(String message) {
        super(message);
    }
}
