package com.vsu.service;

import com.vsu.domain.Client;
import com.vsu.domain.Realtor;
import com.vsu.domain.Realty;

import java.util.List;

public interface RealtorService {
    Realtor insert(Realtor realtor);
    List<Realtor> getAll();

    Realtor getById(int id);
    Realtor getByName(String name);

    Realtor update(int id, String nameClient, String phone);

    void deleteById(int id);


}
