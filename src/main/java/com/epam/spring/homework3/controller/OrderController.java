package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.controller.dto.OrderDTO;
import com.epam.spring.homework3.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/order")
    public List<OrderDTO> getAllOrder() {
        return orderService.getAllOrder();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/order")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order/{id}")
    public OrderDTO getOrderById(@PathVariable long id) {
        return orderService.getOrderById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/order/{id}")
    public OrderDTO updateOrder(@PathVariable long id, @RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(id, orderDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/order/{id}")
    public void deleteOrderById(@PathVariable long id) {
        orderService.deleteOrder(id);
    }
}