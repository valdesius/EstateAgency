package com.vsu.repository;

import com.vsu.domain.Realtor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealtorRepository extends JpaRepository<Realtor, Integer> {
}
