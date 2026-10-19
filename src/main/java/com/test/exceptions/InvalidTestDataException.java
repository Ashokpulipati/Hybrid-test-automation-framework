package com.test.exceptions;

public class InvalidTestDataException extends RuntimeException {

    public InvalidTestDataException(String message) {
        super(message);
    }
}
