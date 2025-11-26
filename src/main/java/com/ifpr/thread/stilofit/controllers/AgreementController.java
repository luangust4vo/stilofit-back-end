package com.ifpr.thread.stilofit.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import com.ifpr.thread.stilofit.dto.AgreementRequestDTO;
import com.ifpr.thread.stilofit.dto.AgreementResponseDTO;
import com.ifpr.thread.stilofit.dto.list.AgreementListDTO;
import com.ifpr.thread.stilofit.dto.mapper.AgreementMapper;
import com.ifpr.thread.stilofit.exceptions.ErrorMessage;
import com.ifpr.thread.stilofit.services.AgreementService;
import com.ifpr.thread.stilofit.models.Agreement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/agreements")
public class AgreementController {

    private final AgreementService agreementService;

    @Operation(summary = "Create a new agreement", description = "Creates a new agreement with the provided details.", responses = {
        @ApiResponse(responseCode = "201", description = "Agreement created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AgreementResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @PostMapping
    public ResponseEntity<AgreementResponseDTO> create(@Valid @RequestBody AgreementRequestDTO agreementRequestDTO) {
        Agreement agreement = agreementService.create(agreementRequestDTO);
        AgreementResponseDTO agreementResponse = AgreementMapper.toResponse(agreement);
        return ResponseEntity.status(201).body(agreementResponse);
    }

    @Operation(summary = "Find Agreement by ID", description = "Retrieves a Agreement by their unique ID.", responses = {
        @ApiResponse(responseCode = "200", description = "Agreement found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AgreementResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Agreement not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),})
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<AgreementResponseDTO> findById(@PathVariable Long id) {
        Agreement agreement = agreementService.findById(id);
        AgreementResponseDTO agreementResponse = AgreementMapper.toResponse(agreement);
        return ResponseEntity.ok(agreementResponse);
    }

    @Operation(summary = "Find all agreements", description = "Retrieves a paginated list of all agreements.", responses = {
        @ApiResponse(responseCode = "200", description = "Agreements found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AgreementResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "No agreements found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @GetMapping("/list-all")
    public ResponseEntity<Page<AgreementListDTO>> findAll(@PageableDefault(size = 30, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Agreement> agreements = agreementService.findAll(pageable);
        Page<AgreementListDTO> agreementResponses = agreements.map(AgreementMapper::toList);
        return ResponseEntity.ok(agreementResponses);
    }

    @Operation(summary = "Find agreements by name", description = "Retrieves a paginated list of agreements by name.", responses = {
        @ApiResponse(responseCode = "200", description = "Agreements found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AgreementResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "No agreements found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @GetMapping("/find-by-name")
    public ResponseEntity<Page<AgreementListDTO>> findByName(@PageableDefault(size = 30, sort = "name", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(name = "name", required = false, defaultValue = "") String name) {
        Page<Agreement> agreements = agreementService.findByName(pageable, name);
        Page<AgreementListDTO> agreementResponses = agreements.map(AgreementMapper::toList);
        return ResponseEntity.ok(agreementResponses);
    }

    @Operation(summary = "Update an existing agreement", description = "Update an existing agreement with the provided details", responses = {
        @ApiResponse(responseCode = "200", description = "Agreement updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AgreementResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Agreement not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @PutMapping("/{id}")
    public ResponseEntity<AgreementResponseDTO> update(@PathVariable Long id, @RequestBody AgreementRequestDTO agreementRequestDTO) {
        Agreement updatedAgreement = agreementService.update(id, agreementRequestDTO);
        AgreementResponseDTO agreementResponse = AgreementMapper.toResponse(updatedAgreement);
        return ResponseEntity.ok(agreementResponse);
    }

}
