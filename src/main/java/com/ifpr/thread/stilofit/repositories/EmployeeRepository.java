package com.ifpr.thread.stilofit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpr.thread.stilofit.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByCpf(String cpf);

    boolean existsByProfessionalRegister(String professionalRegister);
}
