package com.ifpr.thread.stilofit.services;

import org.springframework.stereotype.Service;

import com.ifpr.thread.stilofit.dto.EmployeeRequestDTO;
import com.ifpr.thread.stilofit.exceptions.CpfAlreadyRegisteredException;
import com.ifpr.thread.stilofit.exceptions.ProfessionalRegisterAlreadyExistsException;
import com.ifpr.thread.stilofit.models.Employee;
import com.ifpr.thread.stilofit.repositories.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee create(EmployeeRequestDTO employeeRequestDTO) {
        if (employeeRepository.existsByCpf(employeeRequestDTO.getCpf())) {
            throw new CpfAlreadyRegisteredException("CPF já cadastrado");
        }
        if (employeeRepository.existsByProfessionalRegister(employeeRequestDTO.getProfessionalRegister())) {
            throw new ProfessionalRegisterAlreadyExistsException("Registro profissional já cadastrado");
        }
        Employee employee = new Employee();
        employee.setName(employeeRequestDTO.getName());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setPassword(employeeRequestDTO.getPassword());
        employee.setBirthDate(employeeRequestDTO.getBirthDate());
        employee.setGender(employeeRequestDTO.getGender());
        employee.setMaritalStatus(employeeRequestDTO.getMaritalStatus());
        employee.setCpf(employeeRequestDTO.getCpf());
        employee.setRg(employeeRequestDTO.getRg());
        employee.setProfessionalRegister(employeeRequestDTO.getProfessionalRegister());
        employee.setGuardianPhone(employeeRequestDTO.getGuardianPhone());
        employee.setCellphone(employeeRequestDTO.getCellphone());
        employee.setRole(employeeRequestDTO.getRole());
        employee.setStatus(employeeRequestDTO.getStatus());
        employee.setCep(employeeRequestDTO.getCep());
        employee.setAddress(employeeRequestDTO.getAddress());
        employee.setDistrict(employeeRequestDTO.getDistrict());
        employee.setCity(employeeRequestDTO.getCity());
        employee.setState(employeeRequestDTO.getState());
        employee.setNumber(employeeRequestDTO.getNumber());
        employee.setComplement(employeeRequestDTO.getComplement());
        employee.setShift(employeeRequestDTO.getShift());
        employee.setTimeMin(employeeRequestDTO.getTimeMin());
        employee.setTimeMax(employeeRequestDTO.getTimeMax());
        return employeeRepository.save(employee);
    }
}
