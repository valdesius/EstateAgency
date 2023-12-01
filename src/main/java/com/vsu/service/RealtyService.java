package com.vsu.service;

import com.vsu.domain.enums.RealtyEnum;
import com.vsu.domain.Realty;

import java.util.List;

public interface RealtyService {
    Realty insert(Realty realty);

    List<Realty> getAll();

    Realty getById(int id);

    Realty update(int id, String address, int area, RealtyEnum type, int price);

    void deleteById(int id);
}
