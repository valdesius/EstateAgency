package com.vsu.repository;

import com.vsu.domain.Realtor;
import com.vsu.domain.Realty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealtorRepository extends JpaRepository<Realtor, Integer> {
    Realtor findByName(String name);
}
