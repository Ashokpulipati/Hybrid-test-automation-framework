package com.test.exceptions;

public class CartOperationException extends RuntimeException {

    public CartOperationException(String message) {
        super(message);
    }
}
