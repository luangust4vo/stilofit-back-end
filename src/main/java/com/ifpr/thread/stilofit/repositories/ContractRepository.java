package com.ifpr.thread.stilofit.repositories;

import com.ifpr.thread.stilofit.models.Contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    boolean existsByName(String name);

    @Query("SELECT c FROM Contract c ORDER BY c.name ASC")
    @NonNull
    Page<Contract> findAll(@NonNull Pageable pageable);

    @Query("SELECT c FROM Contract c WHERE LOWER(c.name) LIKE CONCAT('%', LOWER(:name), '%') ORDER BY c.name ASC")
    Page<Contract> findByName(Pageable pageable, @Param("name") String name);
}
