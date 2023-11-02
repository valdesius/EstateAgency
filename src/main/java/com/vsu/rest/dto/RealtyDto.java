package com.vsu.rest.dto;

import com.vsu.domain.Realty;
import com.vsu.domain.enums.RealtyEnum;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RealtyDto {
    private int id;
    private String address;
    private RealtyEnum type;
    private int area;
    private int price;

    public static RealtyDto toDto(Realty realty) {
        return new RealtyDto(
                realty.getId(),
                realty.getAddress(),
                realty.getType(),
                realty.getArea(),
                realty.getPrice());
    }

    public static Realty toDomainObject(RealtyDto realtyDto) {
        return new Realty(
                realtyDto.getId(),
                realtyDto.getAddress(),
                realtyDto.getType(),
                realtyDto.getArea(),
                realtyDto.getPrice());
    }

}
