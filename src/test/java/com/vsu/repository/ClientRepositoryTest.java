package com.vsu.repository;

import com.vsu.domain.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class ClientRepositoryTest {

    @Autowired

    private ClientRepository clientRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void shouldInsertClient() {
        Client expectedClient = Client.builder()
                .id(4)
                .name("Влад")
                .phone("79056598804")
                .build();

        clientRepository.save(expectedClient);
        Client actualClient = clientRepository.getById(4);
        assertThat(actualClient).isEqualTo(expectedClient);
    }

}