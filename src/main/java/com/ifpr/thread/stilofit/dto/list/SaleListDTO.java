package com.ifpr.thread.stilofit.dto.list;

import java.time.LocalDateTime;

import com.ifpr.thread.stilofit.models.Client;

import lombok.Data;

@Data
public class SaleListDTO {

    private Long id;
    private Client client;
    private Double totalAmount;
    private LocalDateTime createdAt;
}
