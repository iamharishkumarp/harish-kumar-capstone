package com.example.ecomshopping.product.service;

import com.example.ecomshopping.product.entity.Product;
import com.example.ecomshopping.product.exception.ProductCategoryNotFoundException;
import com.example.ecomshopping.product.exception.ProductIdNotFoundException;
import com.example.ecomshopping.product.exception.ProductNameNotFoundException;
import com.example.ecomshopping.product.exception.ProductPriceNotFoundException;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(int productId);
    List<Product> findAllProduct();
    List<Product> findByProductName(String productName) throws ProductNameNotFoundException;
    List<Product> findByProductCategory(String productCategory) throws ProductCategoryNotFoundException;
    List<Product> findByProductPrice(int productPrice) throws ProductPriceNotFoundException;
    List<Product> findByProductId(int productId) throws ProductIdNotFoundException;
}
