package com.example.ecomshopping.customer.controller;

import com.example.ecomshopping.customer.entity.Customer;
import com.example.ecomshopping.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addcustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/updatecustomer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/deletecustomer/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
    }

    @GetMapping("/getallcustomers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/findbyname/{customerName}")
    public List<Customer> findByCustomerName(@PathVariable("customerName") String customerName) {
        return customerService.findByCustomerName(customerName);
    }

    @GetMapping("/findbyid/{customerId}")
    public List<Customer> findByCustomerId(@PathVariable("customerId") int customerId) {
        return customerService.findByCustomerId(customerId);
    }

    @GetMapping("/findbyage/{customerAge}")
    public List<Customer> findByCustomerAge(@PathVariable("customerAge") int customerAge) {
        return customerService.findByCustomerAge(customerAge);
    }

    @GetMapping("/findbylocation/{customerLocation}")
    public List<Customer> findByCustomerLocation(@PathVariable("customerLocation") String customerLocation) {
        return customerService.findByCustomerLocation(customerLocation);
    }


}
