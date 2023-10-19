package com.vsu.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

}
