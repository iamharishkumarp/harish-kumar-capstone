package com.example.ecomshopping.order.entity;

import com.example.ecomshopping.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderItemId;
    private int orderProdId;
    private int orderQuantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Product product;

    private int orderProductPrice;
    private int orderProductTotal;
    private boolean orderStatus;
}


