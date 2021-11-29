package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.controller.dto.OrderDTO;
import com.epam.spring.homework4.model.Order;
import com.epam.spring.homework4.repository.OrderRepository;
import com.epam.spring.homework4.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getAllOrder() {
        log.info("Get all order");
        return orderRepository.getAllOrder()
                .stream()
                .map(this::mapOrderToOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(long orderId) {
        log.info("Get order by id");
        Order order = orderRepository.getOrderById(orderId);
        return mapOrderToOrderDTO(order);
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        log.info("Create order");
        Order order = mapOrderDTOToOrder(orderDTO);
        order = orderRepository.createOrder(order);
        return mapOrderToOrderDTO(order);
    }

    @Override
    public OrderDTO updateOrder(long orderId, OrderDTO orderDTO) {
        log.info("Update order");
        Order order = mapOrderDTOToOrder(orderDTO);
        order = orderRepository.updateOrder(orderId, order);
        return mapOrderToOrderDTO(order);
    }

    @Override
    public void deleteOrder(long orderId) {
        log.info("Delete order by id");
        orderRepository.deleteOrder(orderId);
    }

    private OrderDTO mapOrderToOrderDTO(Order order) {
        return OrderDTO.builder()
                .orderId(order.getOrderId())
                .orderDate(order.getOrderDate())
                .costOfDelivery(order.getCostOfDelivery())
                .statusOrder(order.getStatusOrder())
                .directionOfDelivery(order.getDirectionOfDelivery())
                .fullAddress(order.getFullAddress())
                .costOfDelivery(order.getCostOfDelivery())
                .build();
    }

    private Order mapOrderDTOToOrder(OrderDTO orderDTO) {
        return Order.builder()
                .orderId(orderDTO.getOrderId())
                .costOfDelivery(orderDTO.getCostOfDelivery())
                .statusOrder(orderDTO.getStatusOrder())
                .directionOfDelivery(orderDTO.getDirectionOfDelivery())
                .tariff(orderDTO.getTariff())
                .fullAddress(orderDTO.getFullAddress())
                .orderDate(orderDTO.getOrderDate())
                .build();
    }
}