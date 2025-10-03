package com.ifpr.thread.stilofit.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifpr.thread.stilofit.models.Client;
import com.ifpr.thread.stilofit.models.Contract;

import lombok.Data;

@Data
public class SaleResponseDTO {

    private Long id;
    private Client client;
    private List<Contract> contracts;
    private double totalAmount;
    @JsonFormat(pattern = "dd/MM/yyyy-HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "dd/MM/yyyy-HH:mm:ss")
    private LocalDateTime updatedAt;
}
