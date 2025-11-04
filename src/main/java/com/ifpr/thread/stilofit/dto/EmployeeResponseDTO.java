package com.ifpr.thread.stilofit.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ifpr.thread.stilofit.models.enums.Gender;
import com.ifpr.thread.stilofit.models.enums.MaritalStatus;
import com.ifpr.thread.stilofit.models.enums.Role;
import com.ifpr.thread.stilofit.models.enums.Shift;
import com.ifpr.thread.stilofit.models.enums.Status;

import lombok.Data;

@Data
public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private String cpf;
    private String rg;
    private String professionalRegister;
    private String guardianPhone;
    private String cellphone;
    private Role role;
    private Status status;
    private String cep;
    private String address;
    private String district;
    private String city;
    private String state;
    private String number;
    private String complement;
    private Shift shift;
    private LocalTime timeMin;
    private LocalTime timeMax;
    private String[] weekDays;
}
