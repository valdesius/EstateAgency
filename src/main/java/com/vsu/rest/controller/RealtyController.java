package com.vsu.rest.controller;

import com.vsu.domain.enums.RealtyEnum;
import com.vsu.domain.Realty;
import com.vsu.rest.dto.RealtyDto;
import com.vsu.service.RealtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class RealtyController {
    private final RealtyService realtyService;

    @GetMapping("/realty")
    public List<RealtyDto> getAllRealty() {

        return realtyService
                .getAll()
                .stream()
                .map(RealtyDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/realty")
    public RealtyDto insertRealty(@RequestBody RealtyDto realtyDto) {
        Realty realty = realtyService.insert(RealtyDto.toDomainObject(realtyDto));
        return RealtyDto.toDto(realty);
    }

    @PutMapping("/realty/{id}")
    public RealtyDto updateRealty(@PathVariable int id,
                                  @RequestParam String address,
                                  @RequestParam RealtyEnum type,
                                  @RequestParam int area,
                                  @RequestParam int price) {
        Realty realty = realtyService.update(id, address, area, type, price);
        return RealtyDto.toDto(realty);
    }

    @DeleteMapping("/realty/{id}")
    public void deleteRealty(@PathVariable int id) {
        realtyService.deleteById(id);
    }

    @GetMapping("/realty/{id}")
    public RealtyDto getRealtyById(@PathVariable int id) {
        Realty realty = realtyService.getById(id);
        return RealtyDto.toDto(realty);
    }

}
