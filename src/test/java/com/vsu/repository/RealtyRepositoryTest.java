package com.vsu.repository;

import com.vsu.domain.Realty;
import com.vsu.domain.enums.RealtyEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RealtyRepositoryTest {
    @Autowired

    private RealtyRepository realtyRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void shouldInsertRealty() {
        Realty expectedRealty = Realty.builder()
                .id(2).address("wqfqf").type(RealtyEnum.APARTMENT).area(23).price(23232).build();

        realtyRepository.save(expectedRealty);
        Realty actualRealty = realtyRepository.getById(2);
        assertThat(actualRealty).isEqualTo(expectedRealty);
    }


    @Test
    @DisplayName("Удаляет недвижимость по ID")
    void shouldDeleteRealty() {
        int size = realtyRepository.findAll().size();
        realtyRepository.deleteById(2);

        int sizeAfter = realtyRepository.findAll().size();
        assertThat(size - sizeAfter).isEqualTo(1);

    }

}