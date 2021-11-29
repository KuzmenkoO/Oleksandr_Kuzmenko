package com.epam.spring.homework4.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
@Builder
public class DirectionOfDeliveryDTO {
    private long directionId;
    @NotBlank
    private String firstCity;
    @NotBlank
    private String secondCity;
    @PositiveOrZero
    private int distance;
}
