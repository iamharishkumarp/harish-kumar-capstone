package com.example.ecomshopping.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "odrTab")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int customerId;
    private int totalCost;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;
}




