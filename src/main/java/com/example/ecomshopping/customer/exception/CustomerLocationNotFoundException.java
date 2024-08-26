package com.example.ecomshopping.customer.exception;

public class CustomerLocationNotFoundException extends RuntimeException {
    public CustomerLocationNotFoundException(String message) {
        super(message);
    }
}
