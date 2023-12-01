package com.vsu.service;

import com.vsu.domain.Realtor;
import com.vsu.repository.RealtorRepository;
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
public class RealtorServiceImplTest {
    public static final int EXISTING_ID1 = 1;
    public static final String EXISTING_NAME1 = "Сергей Лукьяненко";
    public static final int EXISTING_ID2 = 2;
    public static final int EXISTING_ID3 = 3;
    public static final String EXISTING_NAME2 = "Александр Сергеевич Грибоедов";
    public static final String EXISTING_NAME3 = "Гарри Гаррисон";

    private RealtorService realtorService;

    @Mock
    private RealtorRepository realtorRepository;

    private List<Realtor> realtors;

    @BeforeEach
    void init() {
        realtors = new ArrayList<>();

        Realtor expectedRealtor1 = Realtor.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .build();
        Realtor expectedRealtor2 = Realtor.builder()
                .id(EXISTING_ID2)
                .name(EXISTING_NAME2)
                .build();
        Realtor expectedRealtor3 = Realtor.builder()
                .id(EXISTING_ID3)
                .name(EXISTING_NAME3)
                .build();

        realtors.add(expectedRealtor1);
        realtors.add(expectedRealtor2);
        realtors.add(expectedRealtor3);

        realtorService = new RealtorServiceImpl(realtorRepository);
    }

    @DisplayName("должен получать всех риелторов")
    @Test
    void shouldGetAllRealtors() {
        when(realtorService.getAll()).thenReturn(realtors);

        List<Realtor> expectedRealtors = realtorService.getAll();

        assertThat(expectedRealtors).isEqualTo(realtors);
    }

    @DisplayName("должен получать риелтора по id")
    @Test
    void shouldGetAuthorById() {
        Realtor expectedRealtor = Realtor.builder()
                .id(1)
                .name("Ivan")
                .build();

        when(realtorRepository.getById(1)).thenReturn(expectedRealtor);

        Realtor actualRealtor = realtorService.getById(1);

        assertThat(expectedRealtor).isEqualTo(actualRealtor);
    }

    @DisplayName("должен получать риелтора по имени")
    @Test
    void shouldGetRealtorByName() {
        Realtor expectedRealtor = Realtor.builder()
                .id(4)
                .name("Ivan Ivanov")
                .build();
        when(realtorRepository.findByName("Ivan Ivanov")).thenReturn(expectedRealtor);

        Realtor actualRealtor = realtorService.getByName("Ivan Ivanov");

        assertThat(expectedRealtor).isEqualTo(actualRealtor);
    }
}


