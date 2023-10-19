package com.vsu.service;

import com.vsu.domain.Realtor;
import com.vsu.repository.RealtorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

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
        return realtorRepository.findById(id).get();
    }

    @Override
    public Realtor getByName(String name) {
        return realtorRepository.findByName(name);
    }

    @Override
    public Realtor update(int id, String nameClient, String phone) {
        Realtor realtor = Realtor.builder().id(id).name(nameClient).phone(phone).build();
        return realtorRepository.save(realtor);
    }

    @Override
    public void deleteById(int id) {

        realtorRepository.deleteById(id);

    }
}
