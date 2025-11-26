package com.ifpr.thread.stilofit.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

import com.ifpr.thread.stilofit.models.enums.ContractStatus;
import com.ifpr.thread.stilofit.models.enums.TypeExpire;

@Data
public class ContractResponseDTO {
    private Long id;
    private String name;
    private ContractStatus status;
    private String template;
    private boolean installmentable;
    private Integer installments;
    private Double totalValue;
    private Double installmentsValue;
    private Integer expire;
    private TypeExpire typeExpire;
    private List<String> classRoms;
    private LocalTime timeMin;
    private LocalTime timeMax;
    private String[] weekDays;
}