package com.ifpr.thread.stilofit.dto.mapper;

import com.ifpr.thread.stilofit.dto.ContractRequestDTO;
import com.ifpr.thread.stilofit.dto.ContractResponseDTO;
import com.ifpr.thread.stilofit.models.Contract;

import org.springframework.stereotype.Component;

import com.ifpr.thread.stilofit.dto.list.ContractListDTO;
import com.ifpr.thread.stilofit.utils.WeekDaysUtils;

@Component
public class ContractMapper {
    public static Contract toEntity(ContractRequestDTO dto) {
        Contract contract = new Contract();
        contract.setName(dto.getName());
        contract.setStatus(dto.getStatus());
        contract.setTemplate(dto.getTemplate());
        contract.setInstallmentable(dto.isInstallmentable());
        contract.setInstallments(dto.getInstallments());
        contract.setTotalValue(dto.getTotalValue());
        contract.setInstallmentsValue(dto.getInstallmentsValue());
        contract.setExpire(dto.getExpire());
        contract.setTypeExpire(dto.getTypeExpire());
        // contract.setClassRooms(dto.getClassRooms());
        contract.setTimeMin(dto.getTimeMin());
        contract.setTimeMax(dto.getTimeMax());
        contract.setWeekDays(WeekDaysUtils.mapWeekDaysFromArray(dto.getWeekDays()));
        return contract;
    }

    public static ContractResponseDTO toDTO(Contract contract) {
        ContractResponseDTO dto = new ContractResponseDTO();
        dto.setId(contract.getId());
        dto.setName(contract.getName());
        dto.setStatus(contract.getStatus());
        dto.setTemplate(contract.getTemplate());
        dto.setInstallmentable(contract.isInstallmentable());
        dto.setInstallments(contract.getInstallments());
        dto.setTotalValue(contract.getTotalValue());
        dto.setInstallmentsValue(contract.getInstallmentsValue());
        dto.setExpire(contract.getExpire());
        dto.setTypeExpire(contract.getTypeExpire());
        dto.setClassRoms(contract.getClassRooms());
        dto.setTimeMin(contract.getTimeMin());
        dto.setTimeMax(contract.getTimeMax());
        dto.setWeekDays(WeekDaysUtils.mapWeekDaysToArray(contract.getWeekDays()));
        return dto;
    }

    public static ContractListDTO toList(Contract contract) {
        ContractListDTO dto = new ContractListDTO();
        dto.setId(contract.getId());
        dto.setName(contract.getName());
        dto.setTotalValue(contract.getTotalValue());
        dto.setInstallments(contract.getInstallments());
        dto.setInstallmentsValue(contract.getInstallmentsValue());
        dto.setTypeExpire(contract.getTypeExpire());
        dto.setExpire(contract.getExpire());
        return dto;
    }
}