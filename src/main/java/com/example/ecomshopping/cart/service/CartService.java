package com.example.ecomshopping.cart.service;

import com.example.ecomshopping.cart.entity.Cart;

public interface CartService {
    Cart findByCartId(int cartId);
    void addToCart(int customerId, int productId, int quantity);
    void removeFromCart(int customerId, int productId, int quantity);
    void removeCart(int customerId);
}
