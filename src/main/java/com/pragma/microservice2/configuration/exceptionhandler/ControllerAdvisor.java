package com.pragma.microservice2.configuration.exceptionhandler;

import com.pragma.microservice2.adapters.driven.jpa.mysql.exception.*;
import com.pragma.microservice2.configuration.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ExceptionResponse> handleValidationException(BindException bindException) {
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError error : bindException.getFieldErrors()) {
            errorMessage.append(error.getDefaultMessage()).append("; ");
        }
        errorMessage.delete(errorMessage.length() - 2, errorMessage.length());
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                errorMessage.toString(),
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        ));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionResponse> handleAccessDeniedException(AccessDeniedException accessDeniedException) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ExceptionResponse(
                Constants.ROLE_PERMISSIONS_EXCEPTION_MESSAGE,
                HttpStatus.FORBIDDEN.toString(),
                LocalDateTime.now()
        ));
    }

    @ExceptionHandler(NitAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleNitAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.NIT_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        ));
    }

    @ExceptionHandler(RestaurantByNameAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleRestaurantByNameAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.RESTAURANT_BY_NAME_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        ));
    }

    @ExceptionHandler(DishNameAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleDishNameAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.DISH_BY_NAME_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        ));
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleRestaurantNotFoundException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.RESTAURANT_NOT_FOUND_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        ));
    }

    @ExceptionHandler(WrongOwnerException.class)
    public ResponseEntity<ExceptionResponse> handleWrongOwnerException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.WRONG_OWNER_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        ));
    }

    @ExceptionHandler(NullParametersException.class)
    public ResponseEntity<ExceptionResponse> handleNullParametersException(NullParametersException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        ));
    }

}
