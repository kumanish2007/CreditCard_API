package com.creditCard.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException() {
        super("No data found");
    }
}
