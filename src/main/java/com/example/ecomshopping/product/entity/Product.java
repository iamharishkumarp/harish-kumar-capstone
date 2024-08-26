package com.example.ecomshopping.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Product {
    @Id
    private int productId;
    private String productName;
    private String productCategory;
    private int productPrice;
}
