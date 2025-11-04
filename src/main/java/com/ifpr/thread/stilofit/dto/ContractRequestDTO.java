package com.ifpr.thread.stilofit.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ContractRequestDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String status;

    @NotBlank
    private String template;

    @NotBlank
    private String installmentable;

    private Integer installments;

    @NotNull
    private Double totalValue;

    private Double installmentsValue;

    @NotNull
    private Integer expire;

    @NotBlank
    private String typeExpire;

    private List<String> classRooms;
    private String timeMin;
    private String timeMax;
    private List<String> weekdays;
}