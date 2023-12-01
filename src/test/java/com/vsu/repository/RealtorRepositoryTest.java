package com.vsu.repository;

import com.vsu.domain.Realtor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest

class RealtorRepositoryTest {
    @Autowired

    private RealtorRepository realtorRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void shouldInsertRealtor() {
        Realtor expectedRealtor = Realtor.builder()
                .id(2)
                .name("wdwd")
                .phone("97")
                .build();


        realtorRepository.save(expectedRealtor);
        Realtor actualRealtor = realtorRepository.getById(2);
        assertThat(actualRealtor).isEqualTo(expectedRealtor);
    }


    @Test
    @DisplayName("Удаляет риелторов по ID")
    void shouldDeleteRealtor() {
        int size = realtorRepository.findAll().size();
        realtorRepository.deleteById(2);

        int sizeAfter = realtorRepository.findAll().size();
        assertThat(size-sizeAfter).isEqualTo(1);

    }

}