package com.epam.spring.homework4.model;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Order {
    private long orderId;
    private double costOfDelivery;
    private String fullAddress;
    private StatusOrder statusOrder;
    private DirectionOfDelivery directionOfDelivery;
    private Tariff tariff;
    private Date orderDate;
}