package com.ifpr.thread.stilofit.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.management.relation.Role;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifpr.thread.stilofit.models.enums.Gender;
import com.ifpr.thread.stilofit.models.enums.MaritalStatus;
import com.ifpr.thread.stilofit.models.enums.Shift;
import com.ifpr.thread.stilofit.models.enums.Status;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeRequestDTO {
    @NotBlank(message = "{validation.name.notblank}")
    private String name;
    @Email
    private String email;
    private String password;
    @NotNull(message = "{validation.birth.notblank}")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    @NotNull(message = "{validation.gender.notblank}")
    private Gender gender;
    private MaritalStatus maritalStatus;
    @NotBlank(message = "{validation.cpf.notblank}")
    @Size(max = 14)
    @CPF(message = "{validation.cpf.valid}")
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
}
