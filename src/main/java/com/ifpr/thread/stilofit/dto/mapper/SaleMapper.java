package com.ifpr.thread.stilofit.dto.mapper;

import com.ifpr.thread.stilofit.dto.SaleResponseDTO;
import com.ifpr.thread.stilofit.dto.list.SaleListDTO;
import com.ifpr.thread.stilofit.models.Sale;

public class SaleMapper {

    public static SaleResponseDTO toResponse(Sale sale) {
        SaleResponseDTO dto = new SaleResponseDTO();
        dto.setId(sale.getId());
        dto.setClient(ClientMapper.toList(sale.getClient()));
        dto.setContracts(ContractMapper.toList(sale.getContracts()));
        dto.setCreatedAt(sale.getCreatedAt());
        dto.setTotalAmount(sale.getTotalAmount());
        dto.setUpdatedAt(sale.getUpdatedAt());
        return dto;
    }

    public static SaleListDTO toList(Sale sale) {
        SaleListDTO dto = new SaleListDTO();
        dto.setId(sale.getId());
        dto.setClient(ClientMapper.toList(sale.getClient()));
        dto.setCreatedAt(sale.getCreatedAt());
        dto.setTotalAmount(sale.getTotalAmount());
        return dto;
    }
}