package com.test.exceptions;

public class InvalidProductSelectionException extends RuntimeException {

    public InvalidProductSelectionException(String message) {
        super(message);
    }
}
