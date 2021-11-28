package com.epam.spring.homework3.controller.dto;

import com.epam.spring.homework3.model.DirectionOfDelivery;
import com.epam.spring.homework3.model.StatusOrder;
import com.epam.spring.homework3.model.Tariff;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class OrderDTO {
    private long orderId;
    private double costOfDelivery;
    private String fullAddress;
    private StatusOrder statusOrder;
    private DirectionOfDelivery directionOfDelivery;
    private Tariff tariff;
    private Date orderDate;
}
