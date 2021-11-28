package com.epam.spring.homework3.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DirectionOfDeliveryDTO {
    private long directionId;
    private String firstCity;
    private String secondCity;
    private int distance;
}
