package com.ifpr.thread.stilofit.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ifpr.thread.stilofit.dto.PromotionRequestDTO;
import com.ifpr.thread.stilofit.exceptions.NotFoundException;
import com.ifpr.thread.stilofit.models.Promotion;
import com.ifpr.thread.stilofit.repositories.PromotionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PromotionService {

    private final PromotionRepository promotionRepository;

    public Promotion create(PromotionRequestDTO promotionRequestDTO) {
        Promotion promotion = new Promotion();
        promotion.setName(promotionRequestDTO.getName());
        promotion.setDescription(promotionRequestDTO.getDescription());
        promotion.setDiscountType(promotionRequestDTO.getDiscountType());
        promotion.setValue(promotionRequestDTO.getValue());
        promotion.setTimesApplied(promotionRequestDTO.getTimesApplied());
        Promotion promotionSave = promotionRepository.save(promotion);
        return promotionSave;
    }

    public Promotion findById(Long id) {
        return promotionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Promotion não encontrado com id: " + id));
    }

    public Page<Promotion> findAll(Pageable pageable) {
        return promotionRepository.findAll(pageable);
    }

    public Promotion update(Long id, PromotionRequestDTO promotionRequestDTO) {
        Promotion existPromotion = promotionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Promotion não encontrado com id: " + id));
        existPromotion.setName(promotionRequestDTO.getName());
        existPromotion.setDescription(promotionRequestDTO.getDescription());
        existPromotion.setDiscountType(promotionRequestDTO.getDiscountType());
        existPromotion.setValue(promotionRequestDTO.getValue());
        existPromotion.setTimesApplied(promotionRequestDTO.getTimesApplied());
        Promotion updatePromotion = promotionRepository.save(existPromotion);
        return updatePromotion;
    }
}
