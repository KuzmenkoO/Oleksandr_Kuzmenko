package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getAllOrder();

    Order getOrderById(long orderId);

    Order createOrder(Order order);

    Order updateOrder(long orderId, Order order);

    void deleteOrder(long orderId);
}