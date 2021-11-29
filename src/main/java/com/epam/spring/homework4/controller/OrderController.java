package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.dto.OrderDTO;
import com.epam.spring.homework4.service.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/order")
    @ApiOperation("Get all order")
    public List<OrderDTO> getAllOrder() {
        return orderService.getAllOrder();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/order")
    @ApiOperation("Create order")
    public OrderDTO createOrder(@RequestBody @Valid OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order/{id}")
    @ApiOperation("Get order by id")
    public OrderDTO getOrderById(@PathVariable long id) {
        return orderService.getOrderById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/order/{id}")
    @ApiOperation("Update order")
    public OrderDTO updateOrder(@PathVariable long id, @RequestBody @Valid OrderDTO orderDTO) {
        return orderService.updateOrder(id, orderDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/order/{id}")
    @ApiOperation("Delete order by id")
    public void deleteOrderById(@PathVariable long id) {
        orderService.deleteOrder(id);
    }
}