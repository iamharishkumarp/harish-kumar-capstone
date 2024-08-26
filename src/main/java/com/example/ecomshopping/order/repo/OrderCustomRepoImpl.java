package com.example.ecomshopping.order.repo;

import com.example.ecomshopping.cart.entity.Cart;
import com.example.ecomshopping.cart.entity.CartLine;
import com.example.ecomshopping.customer.entity.Customer;
import com.example.ecomshopping.order.entity.Order;
import com.example.ecomshopping.order.entity.OrderItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderCustomRepoImpl implements OrderCustomRepo {

    @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void orderFromCart(int customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        Cart cart = customer.getCart();
        Order order = new Order();
        order.setCustomerId(customerId);
        List<OrderItem> orderItemList = new ArrayList<>();
        if (cart != null) {
            List<CartLine> cartLines = cart.getItemList();
            for (CartLine prod : cartLines) {
                OrderItem item = new OrderItem();
                item.setProduct(prod.getProduct());
                item.setOrderProdId(prod.getProductId());
                item.setOrderQuantity(prod.getQuantity());
                item.setOrderProductPrice(prod.getUnitCost());
                item.setOrderProductTotal(prod.getTotalCost());
                item.setOrderStatus(true);
                order.setTotalCost(order.getTotalCost() + item.getOrderProductPrice());
                entityManager.persist(item);
                orderItemList.add(item);
            }
            order.setOrderItems(orderItemList);
            entityManager.persist(order);
            customer.setOrder(order);
            entityManager.persist(customer);

            cart.getItemList().clear();
            entityManager.persist(cart);
        }
    }

    @Transactional
    @Override
    public void cancelOrder(int customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        Order order = customer.getOrder();

        if (order != null) {
            List<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem item : orderItems) {
                item.setOrderStatus(false);
                entityManager.persist(item);
            }
            customer.setOrder(null);
            entityManager.remove(order);
            entityManager.persist(customer);
        }
    }
}
