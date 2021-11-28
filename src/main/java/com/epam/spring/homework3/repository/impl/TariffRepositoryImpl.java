package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.model.Tariff;
import com.epam.spring.homework3.repository.TariffRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TariffRepositoryImpl implements TariffRepository {
    private final List<Tariff> tariffList = new ArrayList<>();
    private long id = 1;

    @Override
    public List<Tariff> getAllTariff() {
        return new ArrayList<>(tariffList);
    }

    @Override
    public Tariff getTariffById(long tariffId) {
        return tariffList.stream()
                .filter(tariff -> tariff.getTariffId() == tariffId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tariff is not found!"));
    }

    @Override
    public Tariff updateTariff(long tariffId, Tariff tariff) {
        boolean isDelete = tariffList.removeIf(t -> t.getTariffId() == tariffId);
        if (isDelete) {
            tariff.setTariffId(tariffId);
            tariffList.add(tariff);
        } else {
            throw new RuntimeException("Tariff is not found!");
        }
        return tariff;
    }

    @Override
    public Tariff createTariff(Tariff tariff) {
        tariff.setTariffId(id++);
        tariffList.add(tariff);
        return tariff;
    }

    @Override
    public void deleteTariff(long tariffId) {
        tariffList.remove(getTariffById(tariffId));
    }
}