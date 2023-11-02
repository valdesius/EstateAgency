package com.vsu.rest.dto;

import com.vsu.domain.Realtor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RealtorDto {
    private int id;
    private String name;
    private String phone;
    private String email;

    public static RealtorDto toDto(Realtor realtor) {
        return new RealtorDto(
                realtor.getId(),
                realtor.getName(),
                realtor.getPhone(),
                realtor.getEmail());
    }

    public static Realtor toDomainObject(RealtorDto realtorDto){
        return new Realtor(
                realtorDto.getId(),
                realtorDto.getName(),
                realtorDto.getPhone(),
                realtorDto.getEmail());
    }
}
