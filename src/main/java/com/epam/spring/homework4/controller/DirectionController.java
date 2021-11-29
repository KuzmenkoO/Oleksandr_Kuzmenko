package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.dto.DirectionOfDeliveryDTO;
import com.epam.spring.homework4.service.DirectionOfDeliveryService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DirectionController {
    private final DirectionOfDeliveryService directionService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/direction")
    @ApiOperation("Get all direction")
    public List<DirectionOfDeliveryDTO> getAllDirection() {
        return directionService.getAllDirection();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value = "/direction/{id}")
    @ApiOperation("Get direction by id")
    public DirectionOfDeliveryDTO getDirectionById(@PathVariable long id) {
        return directionService.getDirectionById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/direction")
    @ApiOperation("Create direction")
    public DirectionOfDeliveryDTO createDirection(@RequestBody @Valid DirectionOfDeliveryDTO directionDTO) {
        return directionService.createDirection(directionDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/direction/{id}")
    @ApiOperation("Update direction")
    public DirectionOfDeliveryDTO updateDirection(@PathVariable long id, @RequestBody @Valid DirectionOfDeliveryDTO directionDTO) {
        return directionService.updateDirection(id, directionDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/direction/{id}")
    @ApiOperation("Delete direction by id")
    public void deleteDirection(@PathVariable long id) {
        directionService.deleteDirection(id);
    }
}