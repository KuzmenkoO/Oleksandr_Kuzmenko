package com.epam.spring.homework3.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TariffDTO {
    private long tariffId;
    private double pricePerKilometer;
    private double pricePerKilogram;
    private double pricePerOverSized;
}
