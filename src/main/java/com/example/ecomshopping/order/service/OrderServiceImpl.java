package com.example.ecomshopping.order.service;

import com.example.ecomshopping.order.entity.Order;
import com.example.ecomshopping.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public void orderFromCart(int customerId) {
        orderRepo.orderFromCart(customerId);
    }

    @Override
    public void cancelOrder(int customerId) {
        orderRepo.cancelOrder(customerId);
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

}
