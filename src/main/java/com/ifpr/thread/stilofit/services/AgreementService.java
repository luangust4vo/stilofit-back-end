package com.ifpr.thread.stilofit.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ifpr.thread.stilofit.dto.AgreementRequestDTO;
import com.ifpr.thread.stilofit.exceptions.NotFoundException;
import com.ifpr.thread.stilofit.models.Agreement;
import com.ifpr.thread.stilofit.repositories.AgreementRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AgreementService {

    private final AgreementRepository agreementRepository;

    public Agreement create(AgreementRequestDTO agreementRequestDTO) {
        Agreement agreement = new Agreement();
        agreement.setName(agreementRequestDTO.getName());
        agreement.setDescription(agreementRequestDTO.getDescription());
        agreement.setDiscountType(agreementRequestDTO.getDiscountType());
        agreement.setValue(agreementRequestDTO.getValue());
        agreement.setTimesApplied(agreementRequestDTO.getTimesApplied());
        agreement.setPartnersMinimum(agreementRequestDTO.getPartnersMinimum());
        if (agreementRequestDTO.getAgreementStatus() != null) {
            agreement.setAgreementStatus(agreementRequestDTO.getAgreementStatus());
        }
        Agreement agreementSave = agreementRepository.save(agreement);
        return agreementSave;
    }

    public Agreement findById(Long id) {
        return agreementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Convênio não encontrado com id: " + id));
    }

    public Page<Agreement> findAll(Pageable pageable) {
        return agreementRepository.findAll(pageable);
    }

    public Page<Agreement> findByName(Pageable pageable, String name) {
        return agreementRepository.findByName(pageable, name);
    }

    public Agreement update(Long id, AgreementRequestDTO agreementRequestDTO) {
        Agreement existAgreement = agreementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Convênio não encontrado com id: " + id));
        existAgreement.setName(agreementRequestDTO.getName());
        existAgreement.setDescription(agreementRequestDTO.getDescription());
        existAgreement.setDiscountType(agreementRequestDTO.getDiscountType());
        existAgreement.setValue(agreementRequestDTO.getValue());
        existAgreement.setTimesApplied(agreementRequestDTO.getTimesApplied());
        existAgreement.setPartnersMinimum(agreementRequestDTO.getPartnersMinimum());
        existAgreement.setAgreementStatus(agreementRequestDTO.getAgreementStatus());
        Agreement updateAgreement = agreementRepository.save(existAgreement);
        return updateAgreement;
    }
}
