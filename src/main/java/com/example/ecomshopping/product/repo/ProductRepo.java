package com.example.ecomshopping.product.repo;

import com.example.ecomshopping.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByProductName(String productName);
    List<Product> findByProductCategory(String productCategory);
    List<Product> findByProductPrice(int productPrice);
    List<Product> findByProductId(int productId);
}
