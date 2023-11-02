package com.vsu.rest.dto;

import com.vsu.domain.Client;
import com.vsu.domain.Deal;
import com.vsu.domain.Realtor;
import com.vsu.domain.Realty;
import com.vsu.domain.enums.DealEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DealDto {
    private int id;
    private LocalDate date;
    private DealEnum type;
    private ClientDto clientDto;
    private RealtorDto realtorDto;
    private RealtyDto realtyDto;


    public static DealDto toDto(Deal deal) {
        return new DealDto(
                deal.getId(),
                deal.getDate(),
                deal.getType(),
                ClientDto.toDto(deal.getClient()),
                RealtorDto.toDto(deal.getRealtor()),
                RealtyDto.toDto(deal.getRealty())
        );
    }

    public static Deal toDomainObject(DealDto dealDto, Client client, Realtor realtor, Realty realty) {
        return new Deal(
                dealDto.getId(),
                dealDto.getDate(),
                dealDto.getType(),
                client,
                realtor,
                realty
        );

    }
}
