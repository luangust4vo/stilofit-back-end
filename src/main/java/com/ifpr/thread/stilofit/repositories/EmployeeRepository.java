package com.ifpr.thread.stilofit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import com.ifpr.thread.stilofit.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByCpf(String cpf);

    boolean existsByProfessionalRegister(String professionalRegister);

    @Query("SELECT e FROM Employee e ORDER BY e.name ASC")
    @NonNull
    Page<Employee> findAll(@NonNull Pageable pageable);
}
