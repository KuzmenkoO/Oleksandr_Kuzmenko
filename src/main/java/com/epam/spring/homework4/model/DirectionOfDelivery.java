package com.epam.spring.homework4.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DirectionOfDelivery {
    private long directionId;
    private String firstCity;
    private String secondCity;
    private int distance;
}