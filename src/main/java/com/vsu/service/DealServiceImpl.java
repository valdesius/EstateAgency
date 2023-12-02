package com.vsu.service;

import com.vsu.domain.Client;
import com.vsu.domain.Deal;
import com.vsu.domain.enums.DealEnum;
import com.vsu.domain.enums.RealtyEnum;
import com.vsu.domain.Realtor;
import com.vsu.domain.Realty;
import com.vsu.repository.ClientRepository;
import com.vsu.repository.DealRepository;
import com.vsu.repository.RealtorRepository;
import com.vsu.repository.RealtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {

    private final ClientRepository clientRepository;

    private final RealtorRepository realtorRepository;

    private final RealtyRepository realtyRepository;

    private final DealRepository dealRepository;


//    public void generateRandomDeals(int count) {
//        Random random = new Random();
//        List<Realtor> realtors = realtorRepository.findAll();
//        List<Client> clients = clientRepository.findAll();
//        List<Realty> realties = realtyRepository.findAll();
//
//        for (int i = 0; i < count; i++) {
//            String randomDate = String.valueOf(random.nextInt(30) + 1);
//            String randomType = (random.nextBoolean() ? "Sale" : "Rent");
//            Client randomClient = clients.get(random.nextInt(clients.size()));
//            Realtor randomRealtor = realtors.get(random.nextInt(realtors.size()));
//            Realty randomRealty = realties.get(random.nextInt(realties.size()));
//
//            Deal deal = Deal.builder()
//                    .date(randomDate)
//                    .type(randomType)
//                    .client(randomClient)
//                    .realtor(randomRealtor)
//                    .realty(randomRealty)
//                    .build();
//
//            dealRepository.save(deal);
//        }
//    }


    @Override
    public Deal insert(
            LocalDate date,
            DealEnum type,
            String clientName,
            String clientPhone,
            String clientEmail,
            String realtorName,
            String realtorPhone,
            String realtorEmail,
            String realtyAddress,
            RealtyEnum realtyType,
            int area,
            int price
    ) {
        Client client = clientRepository.findByName(clientName);
        if (client == null) {
            client = Client.builder().name(clientName).phone(clientPhone).email(clientEmail).build();
            client = clientRepository.save(client);
        }

        Realtor realtor = realtorRepository.findByName(realtorName);
        if (realtor == null) {
            realtor = Realtor.builder().name(realtorName).phone(realtorPhone).email(realtorEmail).build();
            realtor = realtorRepository.save(realtor);
        }

        Realty realty = realtyRepository.findByAddress(realtyAddress);
        if (realty == null) {
            realty = Realty.builder().address(realtyAddress).type(realtyType).area(area).price(price).build();
            realty = realtyRepository.save(realty);
        }

        Deal deal = Deal.builder().date(date).type(type).client(client).realtor(realtor).realty(realty).build();

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
    public Deal update(
            int id,
            LocalDate date,
            DealEnum type,
            String clientName,
            String clientPhone,
            String clientEmail,
            String realtorName,
            String realtorPhone,
            String realtorEmail,
            String realtyAddress,
            RealtyEnum realtyType,
            int area,
            int price
    ) {
        Client client = clientRepository.findByName(clientName);
        if (client == null) {
            client = Client.builder().name(clientName).phone(clientPhone).email(clientEmail).build();
            client = clientRepository.save(client);
        }

        Realtor realtor = realtorRepository.findByName(realtorName);
        if (realtor == null) {
            realtor = Realtor.builder().name(realtorName).phone(realtorPhone).email(realtorEmail).build();
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