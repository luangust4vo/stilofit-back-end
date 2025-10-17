package com.ifpr.thread.stilofit.controllers;

import com.ifpr.thread.stilofit.dto.ContractRequestDTO;
import com.ifpr.thread.stilofit.dto.ContractResponseDTO;
import com.ifpr.thread.stilofit.services.ContractService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
@AllArgsConstructor
public class ContractController {
    private final ContractService service;

    @PostMapping
    public ResponseEntity<ContractResponseDTO> create(@Valid @RequestBody ContractRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ContractResponseDTO>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContractResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ContractRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}