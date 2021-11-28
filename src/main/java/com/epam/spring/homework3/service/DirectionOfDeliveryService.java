package com.epam.spring.homework3.service;

import com.epam.spring.homework3.controller.dto.DirectionOfDeliveryDTO;

import java.util.List;

public interface DirectionOfDeliveryService {
    List<DirectionOfDeliveryDTO> getAllDirection();

    DirectionOfDeliveryDTO createDirection(DirectionOfDeliveryDTO directionDTO);

    DirectionOfDeliveryDTO updateDirection(long tariffId, DirectionOfDeliveryDTO directionDTO);

    void deleteDirection(long directionId);

    DirectionOfDeliveryDTO getDirectionById(long tariffId);
}