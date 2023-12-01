package com.vsu.service;

import com.vsu.domain.Client;
import com.vsu.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

//    @PostConstruct
//    public void init() {
//        generateRandomClients(1000);
//    }
//
//    public void generateRandomClients(int count) {
//        Random random = new Random();
//        for (int i = 0; i < count; i++) {
//            String randomName = "Client-" + (i + 1);
//            String randomPhone = "555-" + String.format("%04d", random.nextInt(10000));
//            Client client = Client.builder()
//                    .name(randomName)
//                    .phone(randomPhone)
//                    .build();
//            clientRepository.save(client);
//        }
//    }
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
        return clientRepository.getById(id);
    }

    @Override
    public Client getByName(String name) {
        return clientRepository.findByName(name);
    }

    @Override
    public Client update(int id, String nameClient, String phone) {
        Client client = Client.builder()
                .id(id)
                .name(nameClient)
                .phone(phone)
                .build();
        return clientRepository.save(client);

    }

    @Override
    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }

}
