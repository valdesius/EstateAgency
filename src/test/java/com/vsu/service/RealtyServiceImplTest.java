package com.vsu.service;

import com.vsu.domain.Realty;
import com.vsu.domain.enums.RealtyEnum;
import com.vsu.repository.RealtyRepository;
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
class RealtyServiceImplTest {

    public static final int EXISTING_ID1 = 1;
    public static final String EXISTING_ADDRESS1 = "Какой то адрес";
    public static final String EXISTING_ADDRESS2 = "Какой то адрес";
    public static final String EXISTING_ADDRESS3 = "Какой то адрес";
    public static final RealtyEnum EXISTING_TYPE1 = RealtyEnum.APARTMENT;
    public static final RealtyEnum EXISTING_TYPE2 = RealtyEnum.CONDO;
    public static final RealtyEnum EXISTING_TYPE3 = RealtyEnum.HOUSE;
    public static final int EXISTING_AREA1 = 24;
    public static final int EXISTING_AREA2 = 70;
    public static final int EXISTING_AREA3 = 23;
    public static final int EXISTING_PRICE1 = 3000;
    public static final int EXISTING_PRICE2 = 36000;
    public static final int EXISTING_PRICE3 = 10000;
    public static final int EXISTING_ID2 = 2;
    public static final int EXISTING_ID3 = 3;

    private RealtyService realtyService;

    @Mock
    private RealtyRepository realtyRepository;

    private List<Realty> realties;

    @BeforeEach
    void init() {
        realties = new ArrayList<>();

        Realty expectedRealty1 = Realty.builder()
                .id(EXISTING_ID1)
                .address(EXISTING_ADDRESS1)
                .type(EXISTING_TYPE1)
                .area(EXISTING_AREA1)
                .price(EXISTING_PRICE1)
                .build();
        Realty expectedRealty2 = Realty.builder()
                .id(EXISTING_ID2)
                .address(EXISTING_ADDRESS2)
                .type(EXISTING_TYPE2)
                .area(EXISTING_AREA2)
                .price(EXISTING_PRICE2)
                .build();
        Realty expectedRealty3 = Realty.builder()
                .id(EXISTING_ID3)
                .address(EXISTING_ADDRESS3)
                .type(EXISTING_TYPE3)
                .area(EXISTING_AREA3)
                .price(EXISTING_PRICE3)
                .build();

        realties.add(expectedRealty1);
        realties.add(expectedRealty2);
        realties.add(expectedRealty3);

        realtyService = new RealtyServiceImpl(realtyRepository);
    }

    @DisplayName("должен получать всю недвижимость")
    @Test
    void shouldGetAllRealties() {
        when(realtyService.getAll()).thenReturn(realties);

        List<Realty> expectedRealties = realtyService.getAll();

        assertThat(expectedRealties).isEqualTo(realties);
    }

    @DisplayName("должен получать недвижимость по id")
    @Test
    void shouldGetRealtyById() {
        Realty expectedRealty = Realty.builder()
                .id(4)
                .address("gsgsgs")
                .type(RealtyEnum.CONDO)
                .area(34)
                .price(3424)
                .build();

        when(realtyRepository.getById(4)).thenReturn(expectedRealty);

        Realty actualRealty = realtyService.getById(4);

        assertThat(expectedRealty).isEqualTo(actualRealty);
    }


}