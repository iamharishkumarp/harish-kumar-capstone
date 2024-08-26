package com.example.ecomshopping.cart.repo;

import com.example.ecomshopping.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>, CustomCart{

}
