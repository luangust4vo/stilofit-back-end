package com.ifpr.thread.stilofit.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.ifpr.thread.stilofit.dto.SaleRequestDTO;
import com.ifpr.thread.stilofit.exceptions.NotBlankException;
import com.ifpr.thread.stilofit.exceptions.NotFoundException;
import com.ifpr.thread.stilofit.models.Client;
import com.ifpr.thread.stilofit.models.Contract;
import com.ifpr.thread.stilofit.models.Sale;
import com.ifpr.thread.stilofit.repositories.ClientRepository;
import com.ifpr.thread.stilofit.repositories.ContractRepository;
import com.ifpr.thread.stilofit.repositories.SaleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;
    private final ClientRepository clientRepository;
    private final ContractRepository contractRepository;

    public Sale create(SaleRequestDTO saleRequestDTO) {
        validateSaleFields(saleRequestDTO);

        Client client = clientRepository.findById(saleRequestDTO.getClientId())
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com id: " + saleRequestDTO.getClientId()));
        Contract contract = contractRepository.findById(saleRequestDTO.getContractId())
                .orElseThrow(() -> new NotFoundException("Contrato não encontrado com id: " + saleRequestDTO.getContractId()));
                
        Sale sale = new Sale();
        sale.setClient(client);
        sale.setContract(contract);
        sale.setTotalAmount(saleRequestDTO.getTotalAmount());
        Sale saleSave = saleRepository.save(sale);
        return saleSave;
    }

    public Sale findById(@NonNull Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Venda não encontrada com id: " + id));
    }

    public Page<Sale> findAll(@NonNull Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

    public Page<Sale> findByClient(@NonNull Long clientId, @NonNull Pageable pageable) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com id: " + clientId));

        return saleRepository.findByClient(client, pageable);
    }

    public Sale update(@NonNull Long id, SaleRequestDTO saleRequestDTO) {
        validateSaleFields(saleRequestDTO);
        Client client = clientRepository.findById(saleRequestDTO.getClientId())
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com id: " + saleRequestDTO.getClientId()));
        Contract contract = contractRepository.findById(saleRequestDTO.getContractId())
                .orElseThrow(() -> new NotFoundException("Contrato não encontrado com id: " + saleRequestDTO.getContractId()));
        Sale existSale = saleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Venda não encontrada com id: " + id));
                
        existSale.setClient(client);
        existSale.setContract(contract);
        existSale.setTotalAmount(saleRequestDTO.getTotalAmount());
        Sale updateSale = saleRepository.save(existSale);
        return updateSale;
    }

    private void validateSaleFields(SaleRequestDTO saleRequestDTO) {
        if (saleRequestDTO.getClientId() == null) {
            throw new NotBlankException("O campo 'cliente' é obrigatório.");
        }
        if (saleRequestDTO.getContractId() == null) {
            throw new NotBlankException("O campo 'contrato' é obrigatório.");
        }
        if (saleRequestDTO.getTotalAmount() == null || saleRequestDTO.getTotalAmount() <= 0) {
            throw new NotBlankException("O campo 'valor total' é obrigatório, e deve ser positivo");
        }
    }
}
