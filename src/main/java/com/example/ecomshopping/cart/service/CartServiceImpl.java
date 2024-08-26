package com.example.ecomshopping.cart.service;

import com.example.ecomshopping.cart.entity.Cart;
import com.example.ecomshopping.cart.repo.CartRepo;
import com.example.ecomshopping.customer.exception.CustomerIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepo cartRepo;

    @Override
    public Cart findByCartId(int cartId) {
        return cartRepo.findById(cartId).get();
    }

    @Override
    public void addToCart(int customerId, int productId, int quantity) {
        cartRepo.addToCart(customerId, productId, quantity);
    }

    @Override
    public void removeFromCart(int customerId, int productId, int quantity) {
        cartRepo.removeItemCart(customerId, productId, quantity);
    }

    @Override
    public void removeCart(int customerId) {
        cartRepo.removeCart(customerId);
    }
}
