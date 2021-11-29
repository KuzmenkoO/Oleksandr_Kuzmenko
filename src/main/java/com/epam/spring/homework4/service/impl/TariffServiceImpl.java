package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.controller.dto.TariffDTO;
import com.epam.spring.homework4.model.Tariff;
import com.epam.spring.homework4.repository.TariffRepository;
import com.epam.spring.homework4.service.TariffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService {
    private final TariffRepository tariffRepository;

    @Override
    public List<TariffDTO> getAllTariff() {
        log.info("Get all Tariff");
        return tariffRepository.getAllTariff()
                .stream()
                .map(this::mapTariffToTariffDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TariffDTO createTariff(TariffDTO tariffDTO) {
        log.info("Create Tariff");
        Tariff tariff = mapTariffDTOToTariff(tariffDTO);
        tariff = tariffRepository.createTariff(tariff);
        return mapTariffToTariffDTO(tariff);
    }

    @Override
    public TariffDTO updateTariff(long tariffId, TariffDTO tariffDTO) {
        log.info("Update Tariff");
        Tariff tariff = mapTariffDTOToTariff(tariffDTO);
        tariff = tariffRepository.updateTariff(tariffId, tariff);
        return mapTariffToTariffDTO(tariff);
    }

    @Override
    public void deleteTariff(long tariffId) {
        log.info("Delete Tariff by id");
        tariffRepository.deleteTariff(tariffId);
    }

    @Override
    public TariffDTO getTariffById(long tariffId) {
        log.info("Get tariff by id");
        Tariff tariff = tariffRepository.getTariffById(tariffId);
        return mapTariffToTariffDTO(tariff);
    }

    private Tariff mapTariffDTOToTariff(TariffDTO tariffDTO) {
        return Tariff.builder()
                .tariffId(tariffDTO.getTariffId())
                .pricePerKilogram(tariffDTO.getPricePerKilogram())
                .pricePerKilometer(tariffDTO.getPricePerKilometer())
                .pricePerOverSized(tariffDTO.getPricePerOverSized())
                .build();
    }

    private TariffDTO mapTariffToTariffDTO(Tariff tariff) {
        return TariffDTO.builder()
                .tariffId(tariff.getTariffId())
                .pricePerKilogram(tariff.getPricePerKilogram())
                .pricePerKilometer(tariff.getPricePerKilometer())
                .pricePerOverSized(tariff.getPricePerOverSized())
                .build();
    }
}
