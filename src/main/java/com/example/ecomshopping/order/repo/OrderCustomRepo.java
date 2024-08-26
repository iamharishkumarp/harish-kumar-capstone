package com.example.ecomshopping.order.repo;

public interface OrderCustomRepo {
    void orderFromCart(int customerId);
    void cancelOrder(int customerId);
}
