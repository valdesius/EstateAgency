package com.vsu.service;

import com.vsu.domain.Client;
import com.vsu.repository.ClientRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    @Override
    public Client insert(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(int id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client getByName(String name) {
        return clientRepository.findByName(name);
    }

    @Override
    public Client update(int id, String nameClient) {
        Client client = Client.builder()
                .id(id)
                .name(nameClient)
                .build();
        return clientRepository.save(client);

    }

    @Override
    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }
}
