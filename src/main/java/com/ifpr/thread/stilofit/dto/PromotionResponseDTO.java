package com.ifpr.thread.stilofit.dto;

import com.ifpr.thread.stilofit.models.enums.DiscountType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class PromotionResponseDTO {
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;
    private Double value;
    private Integer timesApplied;
}
