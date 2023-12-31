package com.vsu.domain;


import com.vsu.domain.enums.RealtyEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "realty")
public class Realty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "address")
    private String address;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RealtyEnum type;

    @Column(name = "area")
    private int area;

    @Column(name = "price")
    private int price;


}

