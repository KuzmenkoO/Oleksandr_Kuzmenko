package com.epam.spring.homework4.service;

import com.epam.spring.homework4.controller.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrder();

    OrderDTO getOrderById(long orderId);

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(long orderId, OrderDTO orderDTO);

    void deleteOrder(long orderId);
}