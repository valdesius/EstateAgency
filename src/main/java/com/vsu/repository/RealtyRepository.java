package com.vsu.repository;

import com.vsu.domain.Realty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealtyRepository extends JpaRepository<Realty, Integer> {

    Realty findByAddress(String address);

}
