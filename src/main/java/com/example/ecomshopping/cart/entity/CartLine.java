package com.example.ecomshopping.cart.entity;

import com.example.ecomshopping.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class CartLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartLineId;
    private int productId;
    private int quantity;
    private int unitCost;
    private int totalCost;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cart cart;
}
