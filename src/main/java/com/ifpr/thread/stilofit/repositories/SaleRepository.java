package com.ifpr.thread.stilofit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifpr.thread.stilofit.models.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT s FROM Sale s WHERE s.client = :client")
    Page<Sale> findByClient(@Param("client") int client, Pageable pageable);
}
