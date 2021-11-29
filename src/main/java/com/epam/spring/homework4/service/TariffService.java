package com.epam.spring.homework4.service;

import com.epam.spring.homework4.controller.dto.TariffDTO;

import java.util.List;

public interface TariffService {
    List<TariffDTO> getAllTariff();

    TariffDTO createTariff(TariffDTO tariffDTO);

    TariffDTO updateTariff(long tariffId, TariffDTO tariffDTO);

    void deleteTariff(long tariffId);

    TariffDTO getTariffById(long tariffId);
}