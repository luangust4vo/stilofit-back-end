package com.ifpr.thread.stilofit.repositories;

import com.ifpr.thread.stilofit.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    boolean existsByName(String name);
}