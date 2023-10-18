package com.vsu.service;

import com.vsu.domain.Client;
import com.vsu.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgencyDemoService {

    private final ClientRepository clientRepository;


    public void clientDemo(){
        List<Client> clientList = clientRepository.findAll();
        System.out.println("==============");
        for (Client client : clientList){
            System.out.println(client);
        }

        System.out.println("==============");
        Client client = Client.builder()
                .name("Влад")
                .phone("79056598804")
                .build();

        clientRepository.save(client);
        clientList = clientRepository.findAll();
        System.out.println("==============");
        for (Client client1 : clientList){
            System.out.println(client1);
        }





    }

}
