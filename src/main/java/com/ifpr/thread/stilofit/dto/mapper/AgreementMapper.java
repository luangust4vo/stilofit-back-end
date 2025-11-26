package com.ifpr.thread.stilofit.dto.mapper;

import com.ifpr.thread.stilofit.dto.AgreementResponseDTO;
import com.ifpr.thread.stilofit.dto.list.AgreementListDTO;
import com.ifpr.thread.stilofit.models.Agreement;

public class AgreementMapper {

    public static AgreementResponseDTO toResponse(Agreement agreement) {
        AgreementResponseDTO dto = new AgreementResponseDTO();
        dto.setId(agreement.getId());
        dto.setName(agreement.getName());
        dto.setDescription(agreement.getDescription());
        dto.setDiscountType(agreement.getDiscountType());
        dto.setValue(agreement.getValue());
        dto.setTimesApplied(agreement.getTimesApplied());
        dto.setPartnersMinimum(agreement.getPartnersMinimum());
        dto.setAgreementStatus(agreement.getAgreementStatus());
        return dto;
    }

    public static AgreementListDTO toList(Agreement agreement) {
        AgreementListDTO dto = new AgreementListDTO();
        dto.setId(agreement.getId());
        dto.setName(agreement.getName());
        dto.setDiscountType(agreement.getDiscountType());
        dto.setValue(agreement.getValue());
        dto.setTimesApplied(agreement.getTimesApplied());
        dto.setPartnersMinimum(agreement.getPartnersMinimum());
        return dto;
    }
}
