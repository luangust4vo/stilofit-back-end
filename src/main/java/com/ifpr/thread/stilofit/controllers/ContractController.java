package com.ifpr.thread.stilofit.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifpr.thread.stilofit.dto.ContractRequestDTO;
import com.ifpr.thread.stilofit.dto.ContractResponseDTO;
import com.ifpr.thread.stilofit.dto.list.ContractListDTO;
import com.ifpr.thread.stilofit.dto.mapper.ContractMapper;
import com.ifpr.thread.stilofit.models.Contract;
import com.ifpr.thread.stilofit.services.ContractService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;

@RestController
@AllArgsConstructor
@RequestMapping("/contracts")
public class ContractController {
    private final ContractService service;

    @PostMapping
    public ResponseEntity<ContractResponseDTO> create(@Valid @RequestBody ContractRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/list-all")
    public ResponseEntity<Page<ContractListDTO>> listAll(@NonNull @PageableDefault(size = 30, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(service.listAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractResponseDTO> findById(@NonNull @PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<Page<ContractListDTO>> findByName(@PageableDefault(size = 30, sort = "name", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(name = "name", required = false, defaultValue = "") String name) {
        Page<Contract> contracts = service.findByName(pageable, name);
        Page<ContractListDTO> contractResponses = contracts.map(ContractMapper::toList);
        return ResponseEntity.ok(contractResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContractResponseDTO> update(@NonNull @PathVariable Long id, @Valid @RequestBody ContractRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@NonNull @PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
