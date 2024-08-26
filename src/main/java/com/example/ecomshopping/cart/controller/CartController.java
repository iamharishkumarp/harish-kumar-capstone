package com.example.ecomshopping.cart.controller;

import com.example.ecomshopping.cart.entity.Cart;
import com.example.ecomshopping.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shop/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/additemstocart")
    public void addToCart(@RequestParam int customerId,@RequestParam int productId,@RequestParam int quantity) {
        cartService.addToCart(customerId,productId,quantity);
    }

    @PostMapping("/removeitemsfromcart")
    public void removeFromCart(@RequestParam int customerId, @RequestParam int productId, @RequestParam int quantity) {
        cartService.removeFromCart(customerId,productId,quantity);
    }

    @GetMapping("/findcartbyid/{cartId}")
    public Cart findByCartId(@PathVariable int cartId) {
        return cartService.findByCartId(cartId);
    }

    @DeleteMapping("/deletecart")
    public void removeCart(@RequestParam int customerId) {
        cartService.removeCart(customerId);
    }
}
