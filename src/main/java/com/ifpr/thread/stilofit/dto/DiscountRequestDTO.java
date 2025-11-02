package com.ifpr.thread.stilofit.dto;

import com.ifpr.thread.stilofit.models.enums.DiscountType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DiscountRequestDTO {
    @NotBlank(message = "{validation.name.notblank}")
    private String name;
    private String description;
    @NotNull(message = "{validation.discountType.notnull}")
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;
    @NotNull(message = "{validation.value.notnull}")
    @Positive(message = "{validation.value.positive}")
    private Double value;
    @NotNull(message = "{validation.timesApplied.notnull}")
    @Positive(message = "{validation.timesApplied.positive}")
    private Integer timesApplied;
}
