package com.ifpr.thread.stilofit.dto;

import com.ifpr.thread.stilofit.models.enums.AgreementStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AgreementRequestDTO extends DiscountRequestDTO {
    @NotNull(message = "{validation.partnersMinimum.notnull}")
    @Positive(message = "{validation.partnersMinimum.positive}")
    private Integer partnersMinimum;
    @Enumerated(EnumType.STRING)
    private AgreementStatus agreementStatus;
}