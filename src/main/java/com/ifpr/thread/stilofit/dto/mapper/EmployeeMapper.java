package com.ifpr.thread.stilofit.dto.mapper;

import com.ifpr.thread.stilofit.dto.EmployeeResponseDTO;
import com.ifpr.thread.stilofit.models.Employee;

public class EmployeeMapper {
    public static EmployeeResponseDTO toResponseDTO(Employee employee) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setPassword(employee.getPassword());
        dto.setBirthDate(employee.getBirthDate());
        dto.setGender(employee.getGender());
        dto.setMaritalStatus(employee.getMaritalStatus());
        dto.setCpf(employee.getCpf());
        dto.setRg(employee.getRg());
        dto.setProfessionalRegister(employee.getProfessionalRegister());
        dto.setGuardianPhone(employee.getGuardianPhone());
        dto.setCellphone(employee.getCellphone());
        dto.setRole(employee.getRole());
        dto.setStatus(employee.getStatus());
        dto.setCep(employee.getCep());
        dto.setAddress(employee.getAddress());
        dto.setDistrict(employee.getDistrict());
        dto.setCity(employee.getCity());
        dto.setState(employee.getState());
        dto.setNumber(employee.getNumber());
        dto.setComplement(employee.getComplement());
        dto.setShift(employee.getShift());
        dto.setTimeMin(employee.getTimeMin());
        dto.setTimeMax(employee.getTimeMax());
        return dto;
    }
}
