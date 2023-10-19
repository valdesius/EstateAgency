package com.vsu.service;

import com.vsu.domain.Client;
import com.vsu.domain.Deal;
import com.vsu.domain.Realtor;
import com.vsu.domain.Realty;
import com.vsu.repository.ClientRepository;
import com.vsu.repository.DealRepository;
import com.vsu.repository.RealtorRepository;
import com.vsu.repository.RealtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {

    private final ClientRepository clientRepository;

    private final RealtorRepository realtorRepository;

    private final RealtyRepository realtyRepository;

    private final DealRepository dealRepository;


    @Override
    public Deal insert(String clientName, String clientPhone, String realtorName, String realtorPhone, String realtyAddress) {
        Client client = clientRepository.findByName(clientName);
        if (client == null) {
            client = Client.builder().name(clientName).phone(clientPhone).build();
            client = clientRepository.save(client);
        }

        Realtor realtor = realtorRepository.findByName(realtorName);
        if (realtor == null) {
            realtor = Realtor.builder().name(realtorName).phone(realtorPhone).build();
            realtor = realtorRepository.save(realtor);
        }

        Realty realty = realtyRepository.findByAddress(realtyAddress);
        if (realty == null) {
            realty = Realty.builder().address(realtyAddress).build();
            realty = realtyRepository.save(realty);
        }

        Deal deal = Deal.builder().client(client).realtor(realtor).realty(realty).build();

        return dealRepository.save(deal);
    }

    @Override
    public List<Deal> getAll() {
        return dealRepository.findAll();
    }

    @Override
    public Deal getById(int id) {
        return dealRepository.getById(id);
    }

    @Override
    public Deal getByDate(String date) {
        return null;
    }

    @Override
    public Deal update(int id, String clientName, String clientPhone, String realtorName, String realtorPhone, String realtyAddress) {
        Client client = clientRepository.findByName(clientName);
        if (client == null) {
            client = Client.builder().name(clientName).phone(clientPhone).build();
            client = clientRepository.save(client);
        }

        Realtor realtor = realtorRepository.findByName(realtorName);
        if (realtor == null) {
            realtor = Realtor.builder().name(realtorName).phone(realtorPhone).build();
            realtor = realtorRepository.save(realtor);
        }

        Realty realty = realtyRepository.findByAddress(realtyAddress);
        if (realty == null) {
            realty = Realty.builder().address(realtyAddress).build();
            realty = realtyRepository.save(realty);
        }

        Deal deal = Deal.builder().id(id).client(client).realtor(realtor).realty(realty).build();

        return dealRepository.save(deal);
    }

    @Override
    public void deleteById(int id) {
        dealRepository.deleteById(id);
    }
}