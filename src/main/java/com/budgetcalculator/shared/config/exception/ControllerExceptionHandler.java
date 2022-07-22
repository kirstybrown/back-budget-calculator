package com.budgetcalculator.shared.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return ErrorMessage.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
        return ErrorMessage.builder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build();
    }
}
