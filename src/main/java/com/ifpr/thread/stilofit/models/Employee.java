package com.ifpr.thread.stilofit.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.management.relation.Role;

import com.ifpr.thread.stilofit.models.enums.Gender;
import com.ifpr.thread.stilofit.models.enums.MaritalStatus;
import com.ifpr.thread.stilofit.models.enums.Shift;
import com.ifpr.thread.stilofit.models.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "{validation.name.notblank}")
    private String name;

    @Column(name = "email", unique = true)
    @Email(message = "{validation.email.valid}")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "{validation.password.notblank}")
    private String password;

    @Column(name = "birth_date")
    @NotNull(message = "{validation.birth.notblank}")
    private LocalDate birthDate;

    @Column(name = "gender")
    @NotNull(message = "{validation.gender.notblank}")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "marital_status")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "cpf", nullable = false, unique = true, length = 14)
    @NotBlank(message = "{validation.cpf.notblank}")
    private String cpf;

    @Column(name = "rg", unique = true, nullable = true)
    private String rg;

    @Column(name = "professional_register", unique = true, nullable = true)
    @NotBlank(message = "{validation.professionalRegister.notblank}")
    private String professionalRegister;

    @Column(name = "guardian_phone")
    private String guardianPhone;

    @Column(name = "cellphone")
    private String cellphone;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{validation.role.notnull}")
    private Role role;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{validation.status.notnull}")
    private Status status;

    @Column(name = "cep")
    private String cep;

    @Column(name = "address")
    private String address;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "number")
    private String number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "shift")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{validation.shift.notnull}")
    private Shift shift;

    @Column(name = "time_min")
    @NotNull(message = "{validation.timeMin.notnull}")
    private LocalTime timeMin;

    @Column(name = "time_max")
    @NotNull(message = "{validation.timeMax.notnull}")
    private LocalTime timeMax;

}
