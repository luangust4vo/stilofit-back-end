package com.ifpr.thread.stilofit.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ifpr.thread.stilofit.dto.EmployeeRequestDTO;
import com.ifpr.thread.stilofit.exceptions.CpfAlreadyRegisteredException;
import com.ifpr.thread.stilofit.exceptions.NotFoundException;
import com.ifpr.thread.stilofit.exceptions.ProfessionalRegisterAlreadyExistsException;
import com.ifpr.thread.stilofit.models.Employee;
import com.ifpr.thread.stilofit.repositories.EmployeeRepository;
import com.ifpr.thread.stilofit.utils.WeekDaysUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

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
        employee.setPassword(passwordEncoder.encode(employeeRequestDTO.getPassword())); 
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
        employee.setWeekDays(WeekDaysUtils.mapWeekDaysFromArray(employeeRequestDTO.getWeekDays())); 
        return employeeRepository.save(employee);
    }

    public Employee findById(@NonNull Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Funcionário não encontrado"));
    }

    public Page<Employee> findAll(@NonNull Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee update(@NonNull Long id, EmployeeRequestDTO employeeRequestDTO) {
        Employee existEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Funcionário não encontrado com id: " + id));
                
        existEmployee.setName(employeeRequestDTO.getName());
        existEmployee.setEmail(employeeRequestDTO.getEmail());
        existEmployee.setPassword(passwordEncoder.encode(employeeRequestDTO.getPassword()));
        existEmployee.setBirthDate(employeeRequestDTO.getBirthDate());
        existEmployee.setGender(employeeRequestDTO.getGender());
        existEmployee.setMaritalStatus(employeeRequestDTO.getMaritalStatus());
        existEmployee.setCpf(employeeRequestDTO.getCpf());
        existEmployee.setRg(employeeRequestDTO.getRg());
        existEmployee.setProfessionalRegister(employeeRequestDTO.getProfessionalRegister());
        existEmployee.setGuardianPhone(employeeRequestDTO.getGuardianPhone());
        existEmployee.setCellphone(employeeRequestDTO.getCellphone());
        existEmployee.setRole(employeeRequestDTO.getRole());
        existEmployee.setStatus(employeeRequestDTO.getStatus());
        existEmployee.setCep(employeeRequestDTO.getCep());
        existEmployee.setAddress(employeeRequestDTO.getAddress());
        existEmployee.setDistrict(employeeRequestDTO.getDistrict());
        existEmployee.setCity(employeeRequestDTO.getCity());
        existEmployee.setState(employeeRequestDTO.getState());
        existEmployee.setNumber(employeeRequestDTO.getNumber());
        existEmployee.setComplement(employeeRequestDTO.getComplement());
        existEmployee.setShift(employeeRequestDTO.getShift());
        existEmployee.setTimeMin(employeeRequestDTO.getTimeMin());
        existEmployee.setTimeMax(employeeRequestDTO.getTimeMax());
        existEmployee.setWeekDays(WeekDaysUtils.mapWeekDaysFromArray(employeeRequestDTO.getWeekDays()));
        return employeeRepository.save(existEmployee);
    }
}
