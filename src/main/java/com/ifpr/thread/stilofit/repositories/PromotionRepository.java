package com.ifpr.thread.stilofit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifpr.thread.stilofit.models.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    @Query("SELECT p FROM Promotion p ORDER BY p.name ASC")
    Page<Promotion> findAll(Pageable pageable);
}
