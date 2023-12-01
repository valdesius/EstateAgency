package com.vsu.rest.controller;

import com.vsu.domain.Client;
import com.vsu.rest.dto.ClientDto;
import com.vsu.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/client")
    public List<ClientDto> getAllClient() {
        return clientService
                .getAll()
                .stream()
                .map(ClientDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/client")
    public ClientDto insertClient(@RequestBody ClientDto clientDto) {
        Client client = clientService.insert(ClientDto.toDomainObject(clientDto));
        return ClientDto.toDto(client);

    }

    @PutMapping("/client/{id}")
    public ClientDto updateClient(@PathVariable int id,
                                  @RequestParam String name, @RequestParam String phone) {
        Client client = clientService.update(id, name, phone);
        return ClientDto.toDto(client);

    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable int id) {
        clientService.deleteById(id);
    }

    @GetMapping("/client/{id}")
    public ClientDto getClientById(@PathVariable int id) {
        Client client = clientService.getById(id);
        return ClientDto.toDto(client);
    }

}
