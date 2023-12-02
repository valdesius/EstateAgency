package com.vsu.service;

import com.vsu.domain.Deal;
import com.vsu.domain.enums.DealEnum;
import com.vsu.domain.enums.RealtyEnum;

import java.time.LocalDate;
import java.util.List;

public interface DealService {
    Deal insert(
            LocalDate date,
            DealEnum type,
            String clientName,
            String clientPhone,
            String clientEmail,
            String realtorName,
            String realtorPhone,
            String realtorEmail,
            String realtyAddress,
            RealtyEnum realtyType,
            int area,
            int price
    );

    List<Deal> getAll();

    Deal getById(int id);

    Deal getByDate(String date);

    Deal update(
            int id,
            LocalDate date,
            DealEnum type,
            String clientName,
            String clientPhone,
            String clientEmail,
            String realtorName,
            String realtorPhone,
            String realtorEmail,
            String realtyAddress,
            RealtyEnum realtyType,
            int area,
            int price
    );

    void deleteById(int id);


}