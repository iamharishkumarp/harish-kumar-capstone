package com.example.ecomshopping.cart.repo;

import com.example.ecomshopping.cart.entity.Cart;
import com.example.ecomshopping.cart.entity.CartLine;
import com.example.ecomshopping.customer.entity.Customer;
import com.example.ecomshopping.product.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomCartImpl implements CustomCart{

    @PersistenceContext
    @Autowired
    EntityManager entityManager;

    @Transactional
    public String addToCart(int customerId, int productId, int quantity) {
        Customer customer = entityManager.find(Customer.class, customerId);
        Product product = entityManager.find(Product.class, productId);
        Cart cart = customer.getCart();
        if(cart!=null){
            List<CartLine> cartItems = cart.getItemList();
            for(CartLine item : cartItems){
                if(item.getProduct()==product){
                    item.setQuantity(item.getQuantity() + quantity);
                    item.setTotalCost((item.getTotalCost()) + (quantity * product.getProductPrice()));
                    return "added";
                }
            }
            CartLine newcartline = new CartLine();
            newcartline.setProduct(product);
            newcartline.setProductId(productId);
            newcartline.setUnitCost( product.getProductPrice());
            newcartline.setQuantity(quantity);
            newcartline.setTotalCost(product.getProductPrice() * quantity);
            entityManager.persist(newcartline);
            cartItems.add(newcartline);
            entityManager.persist(cart);
            customer.setCart(cart);
            entityManager.persist(customer);
        }else{
            Cart newcart = new Cart();
            newcart.setCustomer(customer);
            CartLine newcartline = new CartLine();
            newcartline.setProduct(product);
            newcartline.setProductId(productId);
            newcartline.setUnitCost(product.getProductPrice());
            newcartline.setQuantity(quantity);
            newcartline.setTotalCost(product.getProductPrice() * quantity);
            newcart.getItemList().add(newcartline);
            entityManager.persist(newcartline);
            entityManager.persist(newcart);
            customer.setCart(newcart);
            entityManager.persist(customer);
        }
        return "added";
    }

    @Transactional
    public void removeItemCart(int customerId, int productId, int quantity) {
        Customer customer = entityManager.find(Customer.class, customerId);
        Product product = entityManager.find(Product.class, productId);
        Cart cart = customer.getCart();
        if (cart!=null) {
            List<CartLine> cartItems = cart.getItemList();
            for (CartLine item : cartItems) {
                if (item.getProduct() == product) {
                    if (item.getQuantity() > 1) {
                        item.setQuantity(item.getQuantity() - quantity);
                        item.setTotalCost((item.getTotalCost() - (quantity * product.getProductPrice())));
                    }
                    else {
                        cartItems.remove(item);
                        break;
                    }
                }
            }
        }
        customer.setCart(cart);
        entityManager.persist(customer);
    }

    @Override
    public void removeCart(int customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        Cart cart = customer.getCart();
        cart.setItemList(null);
        entityManager.persist(cart);
        entityManager.persist(customer);
    }
}
