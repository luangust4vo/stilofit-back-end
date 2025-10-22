package com.ifpr.thread.stilofit.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import com.ifpr.thread.stilofit.dto.PromotionRequestDTO;
import com.ifpr.thread.stilofit.dto.PromotionResponseDTO;
import com.ifpr.thread.stilofit.dto.list.PromotionListDTO;
import com.ifpr.thread.stilofit.dto.mapper.PromotionMapper;
import com.ifpr.thread.stilofit.exceptions.ErrorMessage;
import com.ifpr.thread.stilofit.services.PromotionService;
import com.ifpr.thread.stilofit.models.Promotion;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/promotions")
@CrossOrigin("http://localhost:5173")
public class PromotionController {

    private final PromotionService promotionService;

    @Operation(summary = "Create a new promotion", description = "Creates a new promotion with the provided details.", responses = {
        @ApiResponse(responseCode = "201", description = "Promotion created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PromotionResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @PostMapping
    public ResponseEntity<PromotionResponseDTO> create(@Valid @RequestBody PromotionRequestDTO promotionRequestDTO) {
        Promotion promotion = promotionService.create(promotionRequestDTO);
        PromotionResponseDTO promotionResponse = PromotionMapper.toResponse(promotion);
        return ResponseEntity.status(201).body(promotionResponse);
    }

    @Operation(summary = "Find Promotion by ID", description = "Retrieves a Promotion by their unique ID.", responses = {
        @ApiResponse(responseCode = "200", description = "Promotion found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PromotionResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Promotion not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),})
    @GetMapping("/{id}")
    public ResponseEntity<PromotionResponseDTO> findById(@PathVariable Long id) {
        Promotion promotion = promotionService.findById(id);
        PromotionResponseDTO promotionResponse = PromotionMapper.toResponse(promotion);
        return ResponseEntity.ok(promotionResponse);
    }

    @Operation(summary = "Find all promotions", description = "Retrieves a paginated list of all promotions.", responses = {
        @ApiResponse(responseCode = "200", description = "Promotions found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PromotionResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "No promotions found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @GetMapping("/list-all-promotions")
    public ResponseEntity<Page<PromotionListDTO>> findAll(@PageableDefault(size = 30, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Promotion> promotions = promotionService.findAll(pageable);
        Page<PromotionListDTO> promotionResponses = promotions.map(PromotionMapper::toList);
        return ResponseEntity.ok(promotionResponses);
    }

    @Operation(summary = "Update an existing promotion", description = "Update an existing promotion with the provided details", responses = {
        @ApiResponse(responseCode = "200", description = "Promotion updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PromotionResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Promotion not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @PutMapping("/{id}")
    public ResponseEntity<PromotionResponseDTO> update(@PathVariable Long id, @RequestBody PromotionRequestDTO promotionRequestDTO) {
        Promotion updatedPromotion = promotionService.update(id, promotionRequestDTO);
        PromotionResponseDTO promotionResponse = PromotionMapper.toResponse(updatedPromotion);
        return ResponseEntity.ok(promotionResponse);
    }

}
