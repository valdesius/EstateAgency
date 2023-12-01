package com.vsu.service;

import com.vsu.domain.Client;
import com.vsu.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {
    public static final int EXISTING_ID1 = 1;
    public static final String EXISTING_NAME1 = "Сергей Лукьяненко";
    public static final String EXISTING_PHONE1 = "97768";
    public static final int EXISTING_ID2 = 2;
    public static final int EXISTING_ID3 = 3;
    public static final String EXISTING_NAME2 = "Александр Сергеевич Грибоедов";

    public static final String EXISTING_PHONE2 = "97755568";
    public static final String EXISTING_PHONE3 = "42342344";
    public static final String EXISTING_NAME3 = "Гарри Гаррисон";

    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    private List<Client> clients;

    @BeforeEach
    void init() {
        clients = new ArrayList<>();

        Client expectedClient1 = Client.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .phone(EXISTING_PHONE1)
                .build();
        Client expectedClient2 = Client.builder()
                .id(EXISTING_ID2)
                .name(EXISTING_NAME2)
                .phone(EXISTING_PHONE2)
                .build();
        Client expectedClient3 = Client.builder()
                .id(EXISTING_ID3)
                .name(EXISTING_NAME3)
                .phone(EXISTING_PHONE3)
                .build();

        clients.add(expectedClient1);
        clients.add(expectedClient2);
        clients.add(expectedClient3);

        clientService = new ClientServiceImpl(clientRepository);
    }

    @DisplayName("должен получать всех клиентов")
    @Test
    void shouldGetAllClients() {
        when(clientService.getAll()).thenReturn(clients);

        List<Client> expectedClients = clientService.getAll();

        assertThat(expectedClients).isEqualTo(clients);
    }

    @DisplayName("должен получать клиента по id")
    @Test
    void shouldGetClientById() {
        Client expectedAuthor = Client.builder()
                .id(4)
                .name("Ivan").phone("534534")
                .build();

        when(clientRepository.getById(4)).thenReturn(expectedAuthor);

        Client actualAuthor = clientService.getById(4);

        assertThat(expectedAuthor).isEqualTo(actualAuthor);
    }

    @DisplayName("должен получать клиента по имени")
    @Test
    void shouldGetClientByName() {
        Client expectedAuthor = Client.builder()
                .id(4)
                .name("Ivan Ivanov").phone("43545")
                .build();
        when(clientRepository.findByName("Ivan Ivanov")).thenReturn(expectedAuthor);

        Client actualAuthor = clientService.getByName("Ivan Ivanov");

        assertThat(expectedAuthor).isEqualTo(actualAuthor);
    }


}
