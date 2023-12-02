package com.vsu.service;

import com.vsu.domain.Client;

import java.util.List;

public interface ClientService {

    Client insert(Client client);
    List<Client> getAll();

    Client getById(int id);
    Client getByName(String name);

    Client update(int id, String nameClient, String phone, String email);

    void deleteById(int id);
}
