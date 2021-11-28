package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.controller.dto.DirectionOfDeliveryDTO;
import com.epam.spring.homework3.model.DirectionOfDelivery;
import com.epam.spring.homework3.repository.DirectionOfDeliveryRepository;
import com.epam.spring.homework3.service.DirectionOfDeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DirectionOfDeliveryServiceImpl implements DirectionOfDeliveryService {
    private final DirectionOfDeliveryRepository directionRepository;

    @Override
    public List<DirectionOfDeliveryDTO> getAllDirection() {
        log.info("Get all direction");
        return directionRepository.getAllDirectionOfDelivery()
                .stream()
                .map(this::mapDirectionToDirectionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DirectionOfDeliveryDTO createDirection(DirectionOfDeliveryDTO directionDTO) {
        log.info("Create direction");
        DirectionOfDelivery direction = mapDirectionDTOToDirection(directionDTO);
        direction = directionRepository.createDirectionOfDelivery(direction);
        return mapDirectionToDirectionDTO(direction);
    }

    @Override
    public DirectionOfDeliveryDTO updateDirection(long tariffId, DirectionOfDeliveryDTO directionDTO) {
        log.info("Update direction");
        DirectionOfDelivery direction = mapDirectionDTOToDirection(directionDTO);
        direction = directionRepository.updateDirectionOfDelivery(tariffId, direction);
        return mapDirectionToDirectionDTO(direction);
    }

    @Override
    public void deleteDirection(long directionId) {
        log.info("Delete direction");
        directionRepository.deleteDirectionOfDelivery(directionId);
    }

    @Override
    public DirectionOfDeliveryDTO getDirectionById(long tariffId) {
        log.info("Get direction by id");
        DirectionOfDelivery direction = directionRepository.getDirectionOfDeliveryById(tariffId);
        return mapDirectionToDirectionDTO(direction);
    }

    private DirectionOfDeliveryDTO mapDirectionToDirectionDTO(DirectionOfDelivery directionOfDelivery) {
        return DirectionOfDeliveryDTO.builder()
                .directionId(directionOfDelivery.getDirectionId())
                .distance(directionOfDelivery.getDistance())
                .firstCity(directionOfDelivery.getFirstCity())
                .secondCity(directionOfDelivery.getSecondCity())
                .build();
    }

    private DirectionOfDelivery mapDirectionDTOToDirection(DirectionOfDeliveryDTO directionOfDeliveryDTO) {
        return DirectionOfDelivery.builder()
                .directionId(directionOfDeliveryDTO.getDirectionId())
                .distance(directionOfDeliveryDTO.getDistance())
                .firstCity(directionOfDeliveryDTO.getFirstCity())
                .secondCity(directionOfDeliveryDTO.getSecondCity())
                .build();
    }
}