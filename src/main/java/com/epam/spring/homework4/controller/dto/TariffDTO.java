package com.epam.spring.homework4.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Positive;

@Data
@Builder
public class TariffDTO {
    private long tariffId;
    @Positive
    private double pricePerKilometer;
    @Positive
    private double pricePerKilogram;
    @Positive
    private double pricePerOverSized;
}