package com.example.ecomshopping.customer.service;

import com.example.ecomshopping.customer.entity.Customer;
import com.example.ecomshopping.customer.exception.CustomerAgeNotFoundException;
import com.example.ecomshopping.customer.exception.CustomerIdNotFoundException;
import com.example.ecomshopping.customer.exception.CustomerLocationNotFoundException;
import com.example.ecomshopping.customer.exception.CustomerNameNotFoundException;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
    List<Customer> getAllCustomers();

    List<Customer> findByCustomerId(int customerId) throws CustomerIdNotFoundException;
    List<Customer> findByCustomerName(String customerName) throws CustomerNameNotFoundException;
    List<Customer> findByCustomerAge(int customerAge) throws CustomerAgeNotFoundException;
    List<Customer> findByCustomerLocation(String customerLocationName) throws CustomerLocationNotFoundException;
}
