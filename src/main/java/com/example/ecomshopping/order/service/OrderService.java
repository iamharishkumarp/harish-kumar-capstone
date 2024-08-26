package com.example.ecomshopping.order.service;

import com.example.ecomshopping.order.entity.Order;

import java.util.List;

public interface OrderService {
    void orderFromCart(int customerId);
    void cancelOrder(int customerId);
    List<Order> findAll();
}

