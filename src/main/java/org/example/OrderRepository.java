package org.example;

import java.util.*;

public class OrderRepository {
    private static Map<Integer, Order> orders;

    public OrderRepository() {
        this.orders = new HashMap<>();
    }

    public static Order getOrderById(Integer orderId) {
        return orders.get(orderId);
    }

    public static Map<Integer, Order> getAllOrders() {
        return orders;
    }

    public static void addOrder(Order order) {
        orders.put(order.getId(), order);
    }
}





