package com.vsu.repository;

import com.vsu.domain.Deal;
import com.vsu.domain.enums.DealEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

    public interface DealRepository extends JpaRepository<Deal, Integer> {

        @Modifying
        @Query("update Deal d set d.date = :date, d.type = :type where d.id = :id" )
        void updateDealById(@Param("id") int id,
                            @Param("date") LocalDate date,
                            @Param("type") DealEnum dealEnum);

        List<Deal> findByClientId(int id);
    }
