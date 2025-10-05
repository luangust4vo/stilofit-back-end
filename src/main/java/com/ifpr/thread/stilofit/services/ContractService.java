package com.ifpr.thread.stilofit.services;

import com.ifpr.thread.stilofit.dto.ContractRequestDTO;
import com.ifpr.thread.stilofit.dto.ContractResponseDTO;
import com.ifpr.thread.stilofit.dto.mapper.ContractMapper;
import com.ifpr.thread.stilofit.exceptions.ContractNameAlreadyExistsException;
import com.ifpr.thread.stilofit.exceptions.NotFoundException;
import com.ifpr.thread.stilofit.models.Contract;
import com.ifpr.thread.stilofit.repositories.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository repository;
    private final ContractMapper mapper;

    public ContractResponseDTO create(ContractRequestDTO dto) {
        if (repository.existsByName(dto.getName())) {
            throw new ContractNameAlreadyExistsException("Já existe um contrato com esse nome.");
        }
        Contract contract = mapper.toEntity(dto);
        contract = repository.save(contract);
        return mapper.toDTO(contract);
    }

    public List<ContractResponseDTO> listAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ContractResponseDTO findById(Long id) {
        Contract contract = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contrato não encontrado"));
        return mapper.toDTO(contract);
    }

    public ContractResponseDTO update(Long id, ContractRequestDTO dto) {
        Contract contract = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contrato não encontrado"));
        Contract updated = mapper.toEntity(dto);
        updated.setId(id);
        updated = repository.save(updated);
        return mapper.toDTO(updated);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Contrato não encontrado");
        }
        repository.deleteById(id);
    }

}