package com.epam.spring.homework4.controller.dto;

import com.epam.spring.homework4.model.DirectionOfDelivery;
import com.epam.spring.homework4.model.StatusOrder;
import com.epam.spring.homework4.model.Tariff;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@Builder
public class OrderDTO {
    private long orderId;
    @Positive
    private double costOfDelivery;
    @NotBlank
    private String fullAddress;
    private StatusOrder statusOrder;
    private DirectionOfDelivery directionOfDelivery;
    private Tariff tariff;
    private Date orderDate;
}
