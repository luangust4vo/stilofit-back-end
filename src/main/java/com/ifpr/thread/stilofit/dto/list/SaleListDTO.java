package com.ifpr.thread.stilofit.dto.list;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SaleListDTO {

    private Long id;
    private ClientListDTO client;
    private Double totalAmount;
    private LocalDateTime createdAt;
}
