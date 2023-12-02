package com.vsu.rest.controller;


import com.vsu.domain.Deal;
import com.vsu.domain.enums.DealEnum;
import com.vsu.domain.enums.RealtyEnum;
import com.vsu.rest.dto.DealDto;
import com.vsu.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DealController {

    private final DealService dealService;


    @GetMapping("/deal")

    public List<DealDto> getAllDeal() {
        List<DealDto> dealDtoList = dealService.getAll().stream().map(DealDto::toDto).collect(Collectors.toList());
        return dealDtoList;
    }

    @PostMapping("/deal")
    public DealDto insertDeal(
            @RequestParam LocalDate date,
            @RequestParam DealEnum type,
            @RequestParam String clientName,
            @RequestParam String clientPhone,
            @RequestParam String clientEmail,
            @RequestParam String realtorName,
            @RequestParam String realtorPhone,
            @RequestParam String realtorEmail,
            @RequestParam String realtyAddress,
            @RequestParam RealtyEnum realtyType,
            @RequestParam int area,
            @RequestParam int price
    ) {
        Deal deal = dealService.insert(date, type, clientName, clientPhone, clientEmail, realtorName, realtorPhone, realtorEmail, realtyAddress, realtyType, area, price);
        return DealDto.toDto(deal);
    }


    @PutMapping("/deal/{id}")
    public DealDto updateDeal(
            @PathVariable int id,
            @RequestParam LocalDate date,
            @RequestParam DealEnum type,
            @RequestParam String clientName,
            @RequestParam String clientPhone,
            @RequestParam String clientEmail,
            @RequestParam String realtorName,
            @RequestParam String realtorPhone,
            @RequestParam String realtorEmail,
            @RequestParam String realtyAddress,
            @RequestParam RealtyEnum realtyType,
            @RequestParam int area,
            @RequestParam int price
    ) {

        Deal deal = dealService.update(id, date, type, clientName, clientPhone, clientEmail, realtorName, realtorPhone, realtorEmail, realtyAddress, realtyType, area, price);
        return DealDto.toDto(deal);
    }

    @GetMapping("/deal/{id}")
    public DealDto getDealById(@PathVariable int id) {
        return DealDto.toDto(dealService.getById(id));
    }

    @DeleteMapping("/deal/{id}")
    public void deleteDeal(@PathVariable int id) {
        dealService.deleteById(id);
    }
}
