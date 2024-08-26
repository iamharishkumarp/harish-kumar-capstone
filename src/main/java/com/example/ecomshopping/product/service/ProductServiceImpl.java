package com.example.ecomshopping.product.service;

import com.example.ecomshopping.product.entity.Product;
import com.example.ecomshopping.product.exception.ProductCategoryNotFoundException;
import com.example.ecomshopping.product.exception.ProductIdNotFoundException;
import com.example.ecomshopping.product.exception.ProductNameNotFoundException;
import com.example.ecomshopping.product.exception.ProductPriceNotFoundException;
import com.example.ecomshopping.product.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;


    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> findByProductName(String productName) {
        List<Product> product =  productRepo.findByProductName(productName);
        if(product.isEmpty()){
            throw new ProductNameNotFoundException(productName);
        }
        return product;
    }

    @Override
    public List<Product> findByProductCategory(String productCategory) {
        List<Product> product = productRepo.findByProductCategory(productCategory);
        if(product.isEmpty()){
            throw new ProductCategoryNotFoundException(productCategory);
        }
        return product;
    }

    @Override
    public List<Product> findByProductPrice(int productPrice) {
        List<Product> product = productRepo.findByProductPrice(productPrice);
        if(product.isEmpty()){
            throw new ProductPriceNotFoundException(""+productPrice);
        }
        return product;
    }

    @Override
    public List<Product> findByProductId(int productId) {
        List<Product> product = productRepo.findByProductId(productId);
        if(product.isEmpty()){
            throw new ProductIdNotFoundException(""+productId);
        }
        return product;
    }
}