package com.example.ecomshopping.product.controller;

import com.example.ecomshopping.product.entity.Product;
import com.example.ecomshopping.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/updateproduct")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteproduct/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId){
        productService.deleteProduct(productId);
    }

    @GetMapping("/findallproducts")
    public List<Product> findAllProduct(){
        return productService.findAllProduct();
    }

    @GetMapping("/findbyproductname/{productName}")
    public List<Product> findByProductName(@PathVariable("productName")String productName){
        return productService.findByProductName(productName);
    }

    @GetMapping("/findbyproductcategory/{productCategory}")
    public List<Product> findByProductCategory(@PathVariable("productCategory")String productCategory){
        return productService.findByProductCategory(productCategory);
    }

    @GetMapping("/findbyproductprice/{productPrice}")
    public List<Product> findByProductPrice(@PathVariable("productPrice")int productPrice){
        return productService.findByProductPrice(productPrice);
    }

    @GetMapping("/findbyproductid/{productId}")
    public List<Product> findByProductId(@PathVariable("productId")int productId){
        return productService.findByProductId(productId);
    }
}
