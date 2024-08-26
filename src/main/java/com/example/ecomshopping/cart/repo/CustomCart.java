package com.example.ecomshopping.cart.repo;

public interface CustomCart {
    String addToCart(int customerId, int productId, int quantity);
    void removeItemCart(int customerId, int productId, int quantity);
    void removeCart(int customerId);
}
