package com.ifpr.thread.stilofit.dto.mapper;

import com.ifpr.thread.stilofit.dto.PromotionResponseDTO;
import com.ifpr.thread.stilofit.dto.list.PromotionListDTO;
import com.ifpr.thread.stilofit.models.Promotion;

public class PromotionMapper {

    public static PromotionResponseDTO toResponse(Promotion promotion) {
        PromotionResponseDTO dto = new PromotionResponseDTO();
        dto.setId(promotion.getId());
        dto.setName(promotion.getName());
        dto.setDescription(promotion.getDescription());
        dto.setDiscountType(promotion.getDiscountType());
        dto.setValue(promotion.getValue());
        dto.setTimesApplied(promotion.getTimesApplied());
        return dto;
    }

    public static PromotionListDTO toList(Promotion promotion) {
        PromotionListDTO dto = new PromotionListDTO();
        dto.setId(promotion.getId());
        dto.setName(promotion.getName());
        dto.setDiscountType(promotion.getDiscountType());
        dto.setValue(promotion.getValue());
        dto.setTimesApplied(promotion.getTimesApplied());
        return dto;
    }
}
