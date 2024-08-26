package com.example.ecomshopping.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandlerCustomer {

    @ExceptionHandler(CustomerNameNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCustomerNameNotFoundException(CustomerNameNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Customer with Name ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerIdNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCustomerIdNotFoundException(CustomerIdNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Customer with Id ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerAgeNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCustomerAgeNotFoundException(CustomerAgeNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Customer with Age ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerLocationNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCustomerLocationNotFoundException(CustomerLocationNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("No Existing Customer with Location ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
