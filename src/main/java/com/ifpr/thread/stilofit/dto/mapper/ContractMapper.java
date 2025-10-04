package com.ifpr.thread.stilofit.dto.mapper;

import java.util.List;

import com.ifpr.thread.stilofit.dto.ContractRequestDTO;
import com.ifpr.thread.stilofit.dto.ContractResponseDTO;
import com.ifpr.thread.stilofit.models.Contract;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ifpr.thread.stilofit.dto.list.ContractListDTO;

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

    public static ContractListDTO toList(Contract contract) {
        ContractListDTO dto = new ContractListDTO();
        dto.setId(contract.getId());
        dto.setName(contract.getName());
        dto.setTotalValue(contract.getTotalValue());
        return dto;
    }

    public static List<ContractListDTO> toList(List<Contract> contracts) {
        if (contracts == null) {
            return null;
        }
        return contracts.stream()
                .map(ContractMapper::toList)
                .collect(Collectors.toList());
    }
}