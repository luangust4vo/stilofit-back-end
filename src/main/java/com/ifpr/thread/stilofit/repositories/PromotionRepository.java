package com.ifpr.thread.stilofit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import com.ifpr.thread.stilofit.models.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    @Query("SELECT p FROM Promotion p ORDER BY p.name ASC")
    @NonNull
    Page<Promotion> findAll(@NonNull Pageable pageable);

    @Query("SELECT p FROM Promotion p WHERE LOWER(p.name) LIKE CONCAT('%', LOWER(:name), '%') ORDER BY p.name ASC")
    Page<Promotion> findByName(Pageable pageable, @Param("name") String name);
}
