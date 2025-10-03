package com.ifpr.thread.stilofit.dto;

import java.util.List;

import com.ifpr.thread.stilofit.models.Client;
import com.ifpr.thread.stilofit.models.Contract;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class SaleRequestDTO {

    @NotNull(message = "{validation.client.notnull}")
    private Client client;
    private List<Contract> contracts;
    @NotNull(message = "{validation.totalAmount.notnull}")
    @Positive(message = "{validation.totalAmount.positive}")
    private Double totalAmount;
}
