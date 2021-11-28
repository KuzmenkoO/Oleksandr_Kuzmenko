package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tariff {
    private long tariffId;
    private double pricePerKilometer;
    private double pricePerKilogram;
    private double pricePerOverSized;
}