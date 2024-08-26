package com.example.ecomshopping.customer.entity;

import com.example.ecomshopping.cart.entity.Cart;
import com.example.ecomshopping.order.entity.Order;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Customer {
    @Id
    private int customerId;
    private String customerName;
    private int customerAge;
    private String customerLocation;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cart cart;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Order order;
}
