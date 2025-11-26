package com.ifpr.thread.stilofit.dto;

import java.time.LocalTime;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

import com.ifpr.thread.stilofit.models.enums.ContractStatus;
import com.ifpr.thread.stilofit.models.enums.TypeExpire;

import jakarta.validation.constraints.Positive;

@Data
public class ContractRequestDTO {
    @NotBlank(message = "{validation.name.notblank}")
    private String name;

    @NotNull(message = "{validation.status.notnull}")
    @Enumerated(EnumType.STRING)
    private ContractStatus status;

    @NotBlank(message = "{validation.template.notblank}")
    private String template;

    @NotNull(message = "{validation.installmentable.notnull}")
    private boolean installmentable;

    private Integer installments;

    @NotNull(message = "{validation.total_value.notnull}")
    @Positive
    private Double totalValue;

    @Positive
    private Double installmentsValue;

    @NotNull(message = "{validation.expire.notnull}")
    @Positive
    private Integer expire;

    @NotNull(message = "{validation.typeExpire.notnull}")
    @Enumerated(EnumType.STRING)
    private TypeExpire typeExpire;

    private List<String> classRoms;
    private LocalTime timeMin;
    private LocalTime timeMax;
    private List<String> weekDays;
}
