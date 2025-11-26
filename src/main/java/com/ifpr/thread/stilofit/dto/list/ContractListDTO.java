package com.ifpr.thread.stilofit.dto.list;

import com.ifpr.thread.stilofit.models.enums.TypeExpire;

import lombok.Data;

@Data
public class ContractListDTO {
    private Long id;
    private String name;
    private Double totalValue;
    private Integer installments;
    private Double installmentsValue;
    private TypeExpire typeExpire;
    private Integer expire;
}
