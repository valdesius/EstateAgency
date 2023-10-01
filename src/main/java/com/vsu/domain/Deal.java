package com.vsu.domain;


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
@Table(name = "deal")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(targetEntity = Realtor.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "realtor_id")
    private Realtor realtor;

    @ManyToOne(targetEntity = Realty.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "realty_id")
    private Realty realty;




}
