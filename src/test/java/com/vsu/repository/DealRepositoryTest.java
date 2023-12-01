package com.vsu.repository;

import com.vsu.domain.Client;
import com.vsu.domain.Deal;
import com.vsu.domain.Realtor;
import com.vsu.domain.Realty;
import com.vsu.domain.enums.DealEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DealRepositoryTest {

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RealtorRepository realtorRepository;

    @Autowired
    private RealtyRepository realtyRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private Client client;
    private Realtor realtor;
    private Realty realty;

    @BeforeEach
    void setUp() {
        // Assuming there are entities in the database with id 2.
        client = clientRepository.getById(2);
        realtor = realtorRepository.getById(2);
        realty = realtyRepository.getById(2);
    }

    @Test
    void shouldInsertDeal() {
        Deal expectedDeal = Deal.builder()
                .id(2)
                .date(LocalDate.parse("2023-10-02"))
                .type(DealEnum.SELL)
                .client(client)
                .realtor(realtor)
                .realty(realty)
                .build();

        dealRepository.save(expectedDeal);
        Deal actualDeal = dealRepository.getById(2);
        assertThat(actualDeal).isEqualTo(expectedDeal);
    }


    @Test
    @DisplayName("Удаляет сделки по ID")
    void shouldDeleteDeal() {
        int size = dealRepository.findAll().size();
        dealRepository.deleteById(2);

        int sizeAfter = dealRepository.findAll().size();
        assertThat(size-sizeAfter).isEqualTo(1);

    }

}