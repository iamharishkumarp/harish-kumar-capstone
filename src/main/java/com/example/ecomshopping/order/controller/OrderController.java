package com.example.ecomshopping.order.controller;

import com.example.ecomshopping.order.entity.Order;
import com.example.ecomshopping.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop/order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @PostMapping("/orderFromCart")
    public void orderFromCart(@RequestParam int customerId)
    {
        orderService.orderFromCart(customerId);
    }

    @GetMapping("/findallorders")
    public List<Order> findAll()
    {
        return orderService.findAll();
    }

    @DeleteMapping("/delorder/{customerId}")
    public String cancelOrder(@PathVariable int customerId) {
        orderService.cancelOrder(customerId);
        return "Order canceled successfully for customerId: " + customerId;
    }
}

