package com.example.ecomshopping.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandlerProduct {

    @ExceptionHandler(ProductNameNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductNameNotFoundException(ProductNameNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Product with Name ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductIdNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductIdNotFoundException(ProductIdNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Product with Id ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductCategoryNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductCategoryNotFoundException(ProductCategoryNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Product with Category ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductPriceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductPriceNotFoundException(ProductPriceNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Product with Price ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
