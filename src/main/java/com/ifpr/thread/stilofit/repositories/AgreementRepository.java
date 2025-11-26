package com.ifpr.thread.stilofit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifpr.thread.stilofit.models.Agreement;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {

    @Query("SELECT a FROM Agreement a ORDER BY a.name ASC")
    Page<Agreement> findAll(Pageable pageable);

    @Query("SELECT a FROM Agreement a WHERE LOWER(a.name) LIKE CONCAT('%', LOWER(:name), '%') ORDER BY a.name ASC")
    Page<Agreement> findByName(Pageable pageable, @Param("name") String name);
}
