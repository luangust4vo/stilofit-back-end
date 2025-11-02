package com.ifpr.thread.stilofit.dto.list;

import com.ifpr.thread.stilofit.models.enums.DiscountType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class PromotionListDTO {
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;
    private Double value;
    private Integer timesApplied;
}
