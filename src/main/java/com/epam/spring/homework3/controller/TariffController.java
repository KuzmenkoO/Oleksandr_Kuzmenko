package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.controller.dto.TariffDTO;
import com.epam.spring.homework3.service.TariffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TariffController {
    private final TariffService tariffService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/tariff")
    public List<TariffDTO> getAllTariff() {
        return tariffService.getAllTariff();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value = "/tariff/{id}")
    public TariffDTO getTariff(@PathVariable long id) {
        return tariffService.getTariffById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/tariff")
    public TariffDTO createTariff(@RequestBody TariffDTO tariffDTO) {
        return tariffService.createTariff(tariffDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/tariff/{id}")
    public TariffDTO updateTariff(@PathVariable long id, @RequestBody TariffDTO tariffDTO) {
        return tariffService.updateTariff(id, tariffDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/tariff/{id}")
    public void deleteTariff(@PathVariable long id) {
        tariffService.deleteTariff(id);
    }
}