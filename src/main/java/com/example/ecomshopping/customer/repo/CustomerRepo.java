package com.example.ecomshopping.customer.repo;

import com.example.ecomshopping.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerId(int customerId);
    List<Customer> findByCustomerName(String customerName);
    List<Customer> findByCustomerAge(int customerAge);
    List<Customer> findByCustomerLocation(String customerLocationName);
}
