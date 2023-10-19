package com.vsu.service;

import com.vsu.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import com.vsu.domain.Realty;

import java.util.List;



public interface RealtyService {
    Realty insert(Realty realty);

    List<Realty> getAll();

    Realty getById(int id);

    Realty getByAddress(String address);

    Realty update(int id, int area);

    void deleteById(int id);
}