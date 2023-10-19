package com.vsu.service;

import com.vsu.domain.Client;
import com.vsu.domain.Deal;
import com.vsu.domain.Realtor;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgencyDemoService {

    private final ClientService clientService;
    private final RealtorService realtorService;
    private final DealService dealService;


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
        List<Deal> dealList = dealService.getAll();

        for (Deal deal : dealList) {
            System.out.println(deal.getId() + ":"
                    + deal.getClient().getName() + ","
                    + deal.getRealtor().getName() + ","
                    + deal.getRealty().getAddress());

        }


        dealService.insert("Саша", "89089089","Катя", "7899787987","Улица Мира" );

        dealList = dealService.getAll();

        for (Deal deal : dealList) {
            System.out.println(deal.getId() + ":"
                    + deal.getClient().getName() + ","
                    + deal.getRealtor().getName() + ","
                    + deal.getRealty().getAddress());

        }


    }


}
