package com.ifpr.thread.stilofit.dto;

import com.ifpr.thread.stilofit.models.enums.AgreementStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AgreementResponseDTO extends DiscountResponseDTO {
    private Integer partnersMinimum;
    private AgreementStatus agreementStatus;
}