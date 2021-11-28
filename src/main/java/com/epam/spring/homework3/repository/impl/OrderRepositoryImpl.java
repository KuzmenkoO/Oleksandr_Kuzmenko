package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.model.Order;
import com.epam.spring.homework3.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    private final List<Order> orderList = new ArrayList<>();
    long id = 1;

    @Override
    public List<Order> getAllOrder() {
        return new ArrayList<>(orderList);
    }

    @Override
    public Order getOrderById(long orderId) {
        return orderList.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order is not found!"));
    }

    @Override
    public Order createOrder(Order order) {
        order.setOrderId(id++);
        orderList.add(order);
        return order;
    }

    @Override
    public Order updateOrder(long orderId, Order order) {
        boolean isDelete = orderList.removeIf(order1 -> order.getOrderId() == orderId);
        if (isDelete) {
            order.setOrderId(orderId);
            orderList.add(order);
        } else {
            throw new RuntimeException("Order is not found!");
        }
        return order;
    }

    @Override
    public void deleteOrder(long orderId) {
        orderList.remove(getOrderById(orderId));
    }
}