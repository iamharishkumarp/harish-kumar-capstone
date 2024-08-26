package com.example.ecomshopping.customer.exception;

public class CustomerIdNotFoundException extends RuntimeException {
    public CustomerIdNotFoundException(String message) {
        super(message);
    }
}
