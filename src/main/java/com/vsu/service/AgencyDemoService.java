package com.vsu.service;

import com.vsu.domain.Client;
import com.vsu.domain.Deal;
import com.vsu.domain.Realtor;
import com.vsu.domain.enums.DealEnum;
import com.vsu.repository.DealRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgencyDemoService {

    private final ClientService clientService;
    private final RealtorService realtorService;
    private final DealService dealService;
    private final DealRepository dealRepository;


    public void clientDemo() {
        List<Client> clientList = clientService.getAll();
        System.out.println("==============");
        for (Client client : clientList) {
            System.out.println(client);
        }

        System.out.println("==============");


        clientService.update(1, "Влад", "89056598804");
        clientList = clientService.getAll();
        System.out.println("==============");
        for (Client client1 : clientList) {
            System.out.println(client1);
        }

        System.out.println("==============");
    }

    public void realtorDemo() {
        List<Realtor> realtorList = realtorService.getAll();
        System.out.println("==============");
        for (Realtor realtor : realtorList) {
            System.out.println(realtor);
        }

        System.out.println("==============");


        realtorService.update(1, "Семен", "890359884");
        realtorList = realtorService.getAll();
        System.out.println("==============");
        for (Realtor realtor1 : realtorList) {
            System.out.println(realtor1);
        }

        System.out.println("==============");
    }


    @Transactional
    public void dealDemo() {

        dealRepository.updateDealById(4, LocalDate.now(), DealEnum.SELL);
        List<Deal> dealList = dealRepository.findAll();

        for (Deal deal : dealList) {
            System.out.println(deal.getClient().getName() + ":");
            System.out.println(deal.getId() + " - " + deal.getDate() + " - " + deal.getType());

        }


    }


}