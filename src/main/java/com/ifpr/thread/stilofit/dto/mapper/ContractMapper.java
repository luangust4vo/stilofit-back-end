package com.ifpr.thread.stilofit.dto.mapper;

import com.ifpr.thread.stilofit.dto.ContractRequestDTO;
import com.ifpr.thread.stilofit.dto.ContractResponseDTO;
import com.ifpr.thread.stilofit.models.Contract;

import org.springframework.stereotype.Component;

import com.ifpr.thread.stilofit.dto.list.ContractListDTO;

@Component
public class ContractMapper {
    public Contract toEntity(ContractRequestDTO dto) {
        Contract contract = new Contract();
        contract.setName(dto.getName());
        contract.setStatus(dto.getStatus());
        contract.setTemplate(dto.getTemplate());
        contract.setInstallmentable(dto.getInstallmentable());
        contract.setInstallments(dto.getInstallments());
        contract.setTotalValue(dto.getTotalValue());
        contract.setInstallmentsValue(dto.getInstallmentsValue());
        contract.setExpire(dto.getExpire());
        contract.setTypeExpire(dto.getTypeExpire());
        contract.setClassRoms(dto.getClassRoms());
        contract.setTimeMin(dto.getTimeMin());
        contract.setTimeMax(dto.getTimeMax());
        contract.setWeekdays(dto.getWeekdays());
        return contract;
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
        dto.setWeekdays(contract.getWeekdays() == null ? null : contract.getWeekdays().toArray(new String[0]));
        return dto;
    }

        public ContractListDTO toList(Contract contract) {
        ContractListDTO dto = new ContractListDTO();
        dto.setId(contract.getId());
        dto.setName(contract.getName());
        dto.setTotalValue(contract.getTotalValue());
        return dto;
    }
}