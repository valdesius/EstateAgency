package com.vsu.service;

import com.vsu.domain.Deal;

import java.util.List;

public interface DealService {
    Deal insert(String clientName, String clientPhone, String realtorName, String realtyPhone, String realtyAddress);

    List<Deal> getAll();

    Deal getById(int id);

    Deal getByDate(String date);

    Deal update(int id, String clientName, String clientPhone, String realtorName, String realtorPhone, String realtyAddress);

    void deleteById(int id);


}
