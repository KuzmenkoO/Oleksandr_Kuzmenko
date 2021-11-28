package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.model.Tariff;

import java.util.List;

public interface TariffRepository {
    List<Tariff> getAllTariff();

    Tariff getTariffById(long tariffId);

    Tariff updateTariff(long tariffId, Tariff tariff);

    Tariff createTariff(Tariff tariff);

    void deleteTariff(long tariffId);
}