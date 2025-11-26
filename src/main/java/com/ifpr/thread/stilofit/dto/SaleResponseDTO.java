package com.ifpr.thread.stilofit.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifpr.thread.stilofit.dto.list.ClientListDTO;
import com.ifpr.thread.stilofit.dto.list.ContractListDTO;

import lombok.Data;

@Data
public class SaleResponseDTO {

    private Long id;
    private ClientListDTO client;
    private ContractListDTO contract;
    private double totalAmount;
    @JsonFormat(pattern = "dd/MM/yyyy-HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "dd/MM/yyyy-HH:mm:ss")
    private LocalDateTime updatedAt;
}
