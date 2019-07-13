package com.company.Warehouse.Exceptions;

public class InvalidLimitException extends RuntimeException {
    public InvalidLimitException(String message) {
        super(message);
    }
}
