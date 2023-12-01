package com.vsu.service;

import com.vsu.domain.Realtor;
import com.vsu.repository.RealtorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service

public class RealtorServiceImpl implements RealtorService {
    private final RealtorRepository realtorRepository;

    @PostConstruct
    public void init() {
        generateRandomRealtors(1000);
    }

    public void generateRandomRealtors(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            String randomName = "Realtor-" + (i + 1);
            String randomPhone = "555-" + String.format("%04d", random.nextInt(10000));
            Realtor realtor = Realtor.builder()
                    .name(randomName)
                    .phone(randomPhone)
                    .build();
            realtorRepository.save(realtor);
        }
    }

    @Override
    public Realtor insert(Realtor realtor) {
        return realtorRepository.save(realtor);
    }

    @Override
    public List<Realtor> getAll() {
        return realtorRepository.findAll();
    }

    @Override
    public Realtor getById(int id) {
        return realtorRepository.getById(id);
    }

    @Override
    public Realtor getByName(String name) {
        return realtorRepository.findByName(name);
    }

    @Override
    public Realtor update(int id, String name, String phone) {
        Realtor realtor = Realtor.builder()
                .id(id)
                .name(name)
                .phone(phone)
                .build();

        return realtorRepository.save(realtor);
    }

    @Override
    public void deleteById(int id) {
        realtorRepository.deleteById(id);
    }
}
