package com.vsu.service;

import com.vsu.domain.Realty;
import com.vsu.repository.RealtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RealtyServiceImpl implements RealtyService {
    private final RealtyRepository realtyRepository;


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
    public Realty getByArea(int area) {
        return realtyRepository.findByArea(area);
    }


    @Override
    public Realty update(int id, int area) {
        Realty realty = Realty.builder().
                id(id).
                area(area).
                build();


        return realtyRepository.save(realty);
    }

    @Override
    public void deleteById(int id) {
        realtyRepository.deleteById(id);
    }
}
