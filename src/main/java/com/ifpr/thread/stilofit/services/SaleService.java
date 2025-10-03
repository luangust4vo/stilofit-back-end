package com.ifpr.thread.stilofit.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ifpr.thread.stilofit.dto.SaleRequestDTO;
import com.ifpr.thread.stilofit.exceptions.NotBlankException;
import com.ifpr.thread.stilofit.exceptions.NotFoundException;
import com.ifpr.thread.stilofit.models.Sale;
import com.ifpr.thread.stilofit.repositories.SaleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;

    public Sale create(SaleRequestDTO saleRequestDTO) {
        validateSaleFields(saleRequestDTO);
        Sale sale = new Sale();
        sale.setClient(saleRequestDTO.getClient());
        sale.setContracts(saleRequestDTO.getContracts());
        sale.setTotalAmount(saleRequestDTO.getTotalAmount());
        Sale saleSave = saleRepository.save(sale);
        return saleSave;
    }

    public Sale findById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Venda não encontrada com id: " + id));
    }

    public Page<Sale> findAll(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

    public Sale update(Long id, SaleRequestDTO saleRequestDTO) {
        validateSaleFields(saleRequestDTO);
        Sale existSale = saleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Venda não encontrada com id: " + id));
        existSale.setClient(saleRequestDTO.getClient());
        existSale.setContracts(saleRequestDTO.getContracts());
        existSale.setTotalAmount(saleRequestDTO.getTotalAmount());
        Sale updateSale = saleRepository.save(existSale);
        return updateSale;
    }

    private void validateSaleFields(SaleRequestDTO saleRequestDTO) {
        if (saleRequestDTO.getClient() == null) {
            throw new NotBlankException("O campo 'cliente' é obrigatório.");
        }
        if (saleRequestDTO.getTotalAmount() == null || saleRequestDTO.getTotalAmount() <= 0) {
            throw new NotBlankException("O campo 'valor total' é obrigatório, e deve ser positivo");
        }
    }
}
