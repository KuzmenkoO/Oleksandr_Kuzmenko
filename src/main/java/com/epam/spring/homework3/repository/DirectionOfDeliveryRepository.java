package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.model.DirectionOfDelivery;

import java.util.List;

public interface DirectionOfDeliveryRepository {
    List<DirectionOfDelivery> getAllDirectionOfDelivery();

    DirectionOfDelivery createDirectionOfDelivery(DirectionOfDelivery directionOfDelivery);

    DirectionOfDelivery updateDirectionOfDelivery(long directionId, DirectionOfDelivery directionOfDelivery);

    DirectionOfDelivery getDirectionOfDeliveryById(long directionId);

    void deleteDirectionOfDelivery(long directionId);
}