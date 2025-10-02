package com.ifpr.thread.stilofit.dto;

import java.util.List;

import com.ifpr.thread.stilofit.models.Client;
import com.ifpr.thread.stilofit.models.Contract;

import jakarta.validation.constraints.NotNull;

public class SaleRequestDTO {
    @NotNull(message = "{validation.client.notnull}")
    private Client client;
    private List<Contract> contracts;
    @NotNull(message = "{validation.totalAmount.notnull}")
    private double totalAmount;
}
