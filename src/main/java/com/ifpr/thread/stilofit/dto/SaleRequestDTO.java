package com.ifpr.thread.stilofit.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class SaleRequestDTO {

    @NotNull(message = "{validation.client.notnull}")
    private Long clientId;
    private Long contractId;
    @NotNull(message = "{validation.totalAmount.notnull}")
    @Positive(message = "{validation.totalAmount.positive}")
    private Double totalAmount;
}
