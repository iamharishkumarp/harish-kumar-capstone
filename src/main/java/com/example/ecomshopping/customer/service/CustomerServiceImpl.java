package com.example.ecomshopping.customer.service;

import com.example.ecomshopping.customer.entity.Customer;
import com.example.ecomshopping.customer.exception.CustomerAgeNotFoundException;
import com.example.ecomshopping.customer.exception.CustomerIdNotFoundException;
import com.example.ecomshopping.customer.exception.CustomerLocationNotFoundException;
import com.example.ecomshopping.customer.exception.CustomerNameNotFoundException;
import com.example.ecomshopping.customer.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerRepo.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public List<Customer> findByCustomerId(int customerId) {
        List<Customer> customers = customerRepo.findByCustomerId(customerId);
        if (customers.isEmpty()) {
            throw new CustomerIdNotFoundException(""+customerId);
        }
        return customers;
    }

    @Override
    public List<Customer> findByCustomerName(String customerName) {
        List<Customer> customers = customerRepo.findByCustomerName(customerName);
        if (customers.isEmpty()) {
            throw new CustomerNameNotFoundException(customerName);
        }
        return customers;
    }

    @Override
    public List<Customer> findByCustomerAge(int customerAge) {
        List<Customer> customers = customerRepo.findByCustomerAge(customerAge);
        if (customers.isEmpty()) {
            throw new CustomerAgeNotFoundException(""+customerAge);
        }
        return customers;
    }

    @Override
    public List<Customer> findByCustomerLocation(String customerLocationName) {
        List<Customer> customers = customerRepo.findByCustomerLocation(customerLocationName);
        if (customers.isEmpty()) {
            throw new CustomerLocationNotFoundException(customerLocationName);
        }
        return customers;
    }
}
