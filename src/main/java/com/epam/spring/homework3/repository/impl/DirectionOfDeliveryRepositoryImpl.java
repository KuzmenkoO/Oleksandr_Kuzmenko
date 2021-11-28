package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.model.DirectionOfDelivery;
import com.epam.spring.homework3.repository.DirectionOfDeliveryRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DirectionOfDeliveryRepositoryImpl implements DirectionOfDeliveryRepository {
    private long id = 1;
    private final List<DirectionOfDelivery> directionList = new ArrayList<>();

    @Override
    public List<DirectionOfDelivery> getAllDirectionOfDelivery() {
        return new ArrayList<>(directionList);
    }

    @Override
    public DirectionOfDelivery createDirectionOfDelivery(DirectionOfDelivery directionOfDelivery) {
        directionOfDelivery.setDirectionId(id++);
        directionList.add(directionOfDelivery);
        return directionOfDelivery;
    }

    @Override
    public DirectionOfDelivery updateDirectionOfDelivery(long directionId, DirectionOfDelivery directionOfDelivery) {
        boolean isDelete = directionList.removeIf(d -> d.getDirectionId() == directionId);
        if (isDelete){
            directionOfDelivery.setDirectionId(directionId);
            directionList.add(directionOfDelivery);
        }else {
            throw new RuntimeException("Direction is not found!");
        }
        return directionOfDelivery;
    }

    @Override
    public DirectionOfDelivery getDirectionOfDeliveryById(long directionId) {
        return directionList.stream()
                .filter(directionOfDelivery -> directionOfDelivery.getDirectionId()==directionId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Direction is not found!"));
    }

    @Override
    public void deleteDirectionOfDelivery(long directionId) {
        directionList.remove(getDirectionOfDeliveryById(directionId));
    }
}