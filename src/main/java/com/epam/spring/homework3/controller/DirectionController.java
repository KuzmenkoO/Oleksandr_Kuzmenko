package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.controller.dto.DirectionOfDeliveryDTO;
import com.epam.spring.homework3.service.DirectionOfDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DirectionController {
    private final DirectionOfDeliveryService directionService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/direction")
    public List<DirectionOfDeliveryDTO> getAllDirection() {
        return directionService.getAllDirection();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value = "/direction/{id}")
    public DirectionOfDeliveryDTO getDirectionById(@PathVariable long id) {
        return directionService.getDirectionById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/direction")
    public DirectionOfDeliveryDTO createDirection(@RequestBody DirectionOfDeliveryDTO directionDTO) {
        return directionService.createDirection(directionDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/direction/{id}")
    public DirectionOfDeliveryDTO updateDirection(@PathVariable long id, @RequestBody DirectionOfDeliveryDTO directionDTO) {
        return directionService.updateDirection(id, directionDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/direction/{id}")
    public void deleteDirection(@PathVariable long id) {
        directionService.deleteDirection(id);
    }
}