package com.company.Warehouse.Exceptions;

public class WareHouseFullException extends RuntimeException {

    public WareHouseFullException(String message) {
        super(message);
    }
}
