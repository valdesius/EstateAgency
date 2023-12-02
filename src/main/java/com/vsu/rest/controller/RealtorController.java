package com.vsu.rest.controller;

import com.vsu.domain.Realtor;
import com.vsu.rest.dto.RealtorDto;
import com.vsu.service.RealtorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class RealtorController {
    private final RealtorService realtorService;


    @GetMapping("/realtor")
    public List<RealtorDto> getAllRealtor() {


        return realtorService
                .getAll()
                .stream()
                .map(RealtorDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/realtor")
    public RealtorDto insertRealtor(@RequestBody RealtorDto realtorDto) {
        Realtor realtor = realtorService.insert(RealtorDto.toDomainObject(realtorDto));
        return RealtorDto.toDto(realtor);
    }

    @PutMapping("/realtor/{id}")
    public RealtorDto updateRealtor(@PathVariable int id,
                                    @RequestParam String name,
                                    @RequestParam String phone,
                                    @RequestParam String email
    ) {
        Realtor realtor = realtorService.update(id, name, phone, email);
        return RealtorDto.toDto(realtor);
    }

    @DeleteMapping("/realtor/{id}")
    public void deleteRealtor(@PathVariable int id) {
        realtorService.deleteById(id);
    }

    @GetMapping("/realtor/{id}")
    public RealtorDto getRealtorById(@PathVariable int id) {
        Realtor realtor = realtorService.getById(id);
        return RealtorDto.toDto(realtor);
    }

}
