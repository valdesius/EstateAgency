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
    public Realtor update(int id, String name, String phone, String email) {
        Realtor realtor = Realtor.builder()
                .id(id)
                .name(name)
                .phone(phone)
                .email(email)
                .build();

        return realtorRepository.save(realtor);
    }

    @Override
    public void deleteById(int id) {
        realtorRepository.deleteById(id);
    }
}
