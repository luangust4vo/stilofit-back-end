package com.ifpr.thread.stilofit.dto.mapper;

import com.ifpr.thread.stilofit.models.WeekDays;
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
                .weekDays(mapWeekDaysFromArray(dto.getWeekdays()))
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
        dto.setWeekdays(mapWeekDaysToArray(contract.getWeekDays()));
        return dto;
    }

    private WeekDays mapWeekDaysFromArray(String[] weekdays) {
        WeekDays weekDays = new  WeekDays();
        if (weekdays != null) {
            for (String day : weekdays) {
                switch (day.toLowerCase()) {
                    case "monday":
                        weekDays.setMonday(true); break;
                    case "tuesday":
                        weekDays.setTuesday(true); break;
                    case "wednesday":
                        weekDays.setWednesday(true); break;
                    case "thursday":
                        weekDays.setThursday(true); break;
                    case "friday":
                        weekDays.setFriday(true); break;
                    case "saturday":
                        weekDays.setSaturday(true); break;
                    case "sunday":
                        weekDays.setSunday(true); break;
                }
            }
        }
        return weekDays;
    }

    private String[] mapWeekDaysToArray(com.ifpr.thread.stilofit.models.WeekDays weekDays) {
        if (weekDays == null) return new String[0];
        java.util.List<String> days = new java.util.ArrayList<>();
        if (weekDays.isMonday()) days.add("monday");
        if (weekDays.isTuesday()) days.add("tuesday");
        if (weekDays.isWednesday()) days.add("wednesday");
        if (weekDays.isThursday()) days.add("thursday");
        if (weekDays.isFriday()) days.add("friday");
        if (weekDays.isSaturday()) days.add("saturday");
        if (weekDays.isSunday()) days.add("sunday");
        return days.toArray(new String[0]);
    }
}