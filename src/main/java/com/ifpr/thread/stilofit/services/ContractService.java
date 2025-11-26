package com.ifpr.thread.stilofit.services;

import org.springframework.stereotype.Service;

import com.ifpr.thread.stilofit.dto.ContractRequestDTO;
import com.ifpr.thread.stilofit.dto.ContractResponseDTO;
import com.ifpr.thread.stilofit.dto.mapper.ContractMapper;
import com.ifpr.thread.stilofit.dto.list.ContractListDTO;
import com.ifpr.thread.stilofit.exceptions.ContractNameAlreadyExistsException;
import com.ifpr.thread.stilofit.exceptions.NotFoundException;
import com.ifpr.thread.stilofit.models.Contract;
import com.ifpr.thread.stilofit.repositories.ContractRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository repository;

    public ContractResponseDTO create(ContractRequestDTO dto) {
        if (repository.existsByName(dto.getName())) {
            throw new ContractNameAlreadyExistsException("Já existe um contrato com esse nome.");
        }

        Contract contract = ContractMapper.toEntity(dto);
        contract = repository.save(contract);
        return ContractMapper.toDTO(contract);
    }

    public Page<ContractListDTO> listAll(@NonNull Pageable pageable) {
        Page<Contract> contracts = repository.findAll(pageable);
        return contracts.map(ContractMapper::toList);
    }

    public ContractResponseDTO findById(@NonNull Long id) {
        Contract contract = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contrato não encontrado"));
        return ContractMapper.toDTO(contract);
    }

    public ContractResponseDTO update(@NonNull Long id, ContractRequestDTO dto) {
        Contract contract = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contrato não encontrado"));
        
        if (!contract.getName().equals(dto.getName()) && repository.existsByName(dto.getName())) {
            throw new ContractNameAlreadyExistsException("Já existe um contrato com esse nome.");
        }
        
        Contract updated = ContractMapper.toEntity(dto);
        updated.setId(id);
        updated = repository.save(updated);
        return ContractMapper.toDTO(updated);
    }

    public void delete(@NonNull Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Contrato não encontrado");
        }

        repository.deleteById(id);
    }

     public Page<Contract> findAll(@NonNull Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Contract> findByName(Pageable pageable, String name) {
        return repository.findByName(pageable, name);
    }
}
