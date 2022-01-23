package com.budgetcalculator.api.exception;

import org.springframework.stereotype.Component;

import java.io.Serial;

@Component
public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
