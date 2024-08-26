package com.example.ecomshopping.product.exception;

public class ProductPriceNotFoundException extends RuntimeException {
    public ProductPriceNotFoundException(String message){
        super(message);
    }
}
