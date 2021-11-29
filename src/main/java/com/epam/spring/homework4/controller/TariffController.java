package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.dto.TariffDTO;
import com.epam.spring.homework4.service.TariffService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TariffController {
    private final TariffService tariffService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/tariff")
    @ApiOperation("Get all tariff")
    public List<TariffDTO> getAllTariff() {
        return tariffService.getAllTariff();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value = "/tariff/{id}")
    @ApiOperation("Get tariff by id")
    public TariffDTO getTariff(@PathVariable long id) {
        return tariffService.getTariffById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/tariff")
    @ApiOperation("Create tariff")
    public TariffDTO createTariff(@RequestBody @Valid TariffDTO tariffDTO) {
        return tariffService.createTariff(tariffDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/tariff/{id}")
    @ApiOperation("Update tariff")
    public TariffDTO updateTariff(@PathVariable long id, @RequestBody @Valid TariffDTO tariffDTO) {
        return tariffService.updateTariff(id, tariffDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/tariff/{id}")
    @ApiOperation("Delete tariff by id")
    public void deleteTariff(@PathVariable long id) {
        tariffService.deleteTariff(id);
    }
}