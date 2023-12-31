package com.example.poc.reactive.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EntityNotFoundException extends RuntimeException {

    private Object[] codes;

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Object... codes) {
        super(message);
        this.codes = codes;
    }
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
