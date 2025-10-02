package com.ifpr.thread.stilofit.dto.mapper;

import com.ifpr.thread.stilofit.dto.ContractRequestDTO;
import com.ifpr.thread.stilofit.dto.ContractResponseDTO;
import com.ifpr.thread.stilofit.models.Contract;
import org.springframework.stereotype.Component;

@Component
public class ContractMapper {
    public Contract toEntity(ContractRequestDTO dto) {
        return Contract.builder()
                .name(dto.getName())
                .status(dto.getStatus())
                .template(dto.getTemplate())
                .installmentable(dto.getInstallmentable())
                .installments(dto.getInstallments())
                .totalValue(dto.getTotalValue())
                .installmentsValue(dto.getInstallmentsValue())
                .expire(dto.getExpire())
                .typeExpire(dto.getTypeExpire())
                .classRoms(dto.getClassRoms())
                .timeMin(dto.getTimeMin())
                .timeMax(dto.getTimeMax())
                .weekdays(dto.getWeekdays())
                .build();
    }

    public ContractResponseDTO toDTO(Contract contract) {
        ContractResponseDTO dto = new ContractResponseDTO();
        dto.setId(contract.getId());
        dto.setName(contract.getName());
        dto.setStatus(contract.getStatus());
        dto.setTemplate(contract.getTemplate());
        dto.setInstallmentable(contract.getInstallmentable());
        dto.setInstallments(contract.getInstallments());
        dto.setTotalValue(contract.getTotalValue());
        dto.setInstallmentsValue(contract.getInstallmentsValue());
        dto.setExpire(contract.getExpire());
        dto.setTypeExpire(contract.getTypeExpire());
        dto.setClassRoms(contract.getClassRoms());
        dto.setTimeMin(contract.getTimeMin());
        dto.setTimeMax(contract.getTimeMax());
        dto.setWeekdays(contract.getWeekdays());
        return dto;
    }
}