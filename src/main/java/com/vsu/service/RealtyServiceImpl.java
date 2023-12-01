package com.vsu.service;

import com.vsu.domain.enums.RealtyEnum;
import com.vsu.domain.Realty;
import com.vsu.repository.RealtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RealtyServiceImpl implements RealtyService {

    private final RealtyRepository realtyRepository;

//    @PostConstruct
//    public void init() {
//        generateRandomRealty(1000);
//    }

//    public void generateRandomRealty(int count) {
//        Random random = new Random();
//        String[] types = {"apartment", "house", "villa", "condo"};
//        for (int i = 0; i < count; i++) {
//            String randomAddress = "Address-" + (i + 1);
//            int randomArea = random.nextInt(1000) + 500;
//            String randomType = types[random.nextInt(types.length)];
//            int randomPrice = random.nextInt(500000) + 50000;
//            Realty realty = Realty.builder()
//                    .address(randomAddress)
//                    .area(randomArea)
//                    .type(randomType)
//                    .price(randomPrice)
//                    .build();
//            realtyRepository.save(realty);
//        }
//    }

    @Override
    public Realty insert(Realty realty) {
        return realtyRepository.save(realty);
    }

    @Override
    public List<Realty> getAll() {
        return realtyRepository.findAll();
    }

    @Override
    public Realty getById(int id) {
        return realtyRepository.getById(id);
    }

    @Override
    public Realty update(int id, String address, int area, RealtyEnum type, int price) {
        Realty realty = Realty.builder()
                .id(id)
                .address(address)
                .area(area)
                .type(type)
                .price(price)
                .build();
        return realtyRepository.save(realty);
    }

    @Override
    public void deleteById(int id) {
        realtyRepository.deleteById(id);
    }
}
