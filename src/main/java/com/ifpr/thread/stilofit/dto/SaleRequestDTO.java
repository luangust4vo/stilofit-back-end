package com.ifpr.thread.stilofit.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class SaleRequestDTO {

    @NotNull(message = "{validation.client.notnull}")
    private Long clientId;
    private List<Long> contractsIds;
    @NotNull(message = "{validation.totalAmount.notnull}")
    @Positive(message = "{validation.totalAmount.positive}")
    private Double totalAmount;
}
