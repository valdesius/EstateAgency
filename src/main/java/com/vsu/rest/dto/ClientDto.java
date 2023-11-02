package com.vsu.rest.dto;

import com.vsu.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ClientDto {


    private int id;
    private String name;
    private String phone;
    private String email;

    public static ClientDto toDto(Client client) {

        return new ClientDto(
                client.getId(),
                client.getName(),
                client.getPhone(),
                client.getEmail());

    }

    public static Client toDomainObject(ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getName(),
                clientDto.getPhone(),
                clientDto.getEmail());

    }
}
