package com.ifpr.thread.stilofit.dto;

import lombok.Data;

import java.util.List;

@Data
public class ContractResponseDTO {
    private Long id;
    private String name;
    private String status;
    private String template;
    private String installmentable;
    private Integer installments;
    private Double totalValue;
    private Double installmentsValue;
    private Integer expire;
    private String typeExpire;
    private List<String> classRoms;
    private String timeMin;
    private String timeMax;
    private List<String> weekdays;
}