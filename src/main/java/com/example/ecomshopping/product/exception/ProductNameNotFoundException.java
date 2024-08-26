package com.example.ecomshopping.product.exception;

public class ProductNameNotFoundException extends RuntimeException {
    public ProductNameNotFoundException(String message){
        super(message);
    }
}
