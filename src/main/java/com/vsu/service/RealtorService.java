package com.vsu.service;


import com.vsu.domain.Realtor;

import java.util.List;

public interface RealtorService {
    Realtor insert(Realtor realtor);

    List<Realtor> getAll();

    Realtor getById(int id);
    Realtor getByName(String name);

    Realtor update(int id, String name, String phone, String email);

    void deleteById(int id);

}
