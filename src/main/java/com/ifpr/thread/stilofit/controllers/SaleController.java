package com.ifpr.thread.stilofit.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import com.ifpr.thread.stilofit.dto.SaleRequestDTO;
import com.ifpr.thread.stilofit.dto.SaleResponseDTO;
import com.ifpr.thread.stilofit.dto.list.SaleListDTO;
import com.ifpr.thread.stilofit.dto.mapper.SaleMapper;
import com.ifpr.thread.stilofit.exceptions.ErrorMessage;
import com.ifpr.thread.stilofit.services.SaleService;
import com.ifpr.thread.stilofit.models.Sale;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/sales")
@CrossOrigin("http://localhost:5173")
public class SaleController {

    private final SaleService saleService;

    @Operation(summary = "Create a new sale", description = "Creates a new sale with the provided details.", responses = {
        @ApiResponse(responseCode = "201", description = "Sale created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SaleResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @PostMapping
    public ResponseEntity<SaleResponseDTO> create(@Valid @RequestBody SaleRequestDTO saleRequestDTO) {
        Sale sale = saleService.create(saleRequestDTO);
        SaleResponseDTO saleResponse = SaleMapper.toResponse(sale);
        return ResponseEntity.status(201).body(saleResponse);
    }

    @Operation(summary = "Find sale by ID", description = "Retrieves a sale by their unique ID.", responses = {
        @ApiResponse(responseCode = "200", description = "Sale found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SaleResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Sale not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),})
    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> findById(@PathVariable Long id) {
        Sale sale = saleService.findById(id);
        SaleResponseDTO saleResponse = SaleMapper.toResponse(sale);
        return ResponseEntity.ok(saleResponse);
    }

    @Operation(summary = "Find all sales", description = "Retrieves a paginated list of all sales.", responses = {
        @ApiResponse(responseCode = "200", description = "Sales found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SaleResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "No sales found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @GetMapping("/list-all-sales")
    public ResponseEntity<Page<SaleListDTO>> findAll(@PageableDefault(size = 30, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Sale> sales = saleService.findAll(pageable);
        Page<SaleListDTO> saleResponses = sales.map(SaleMapper::toList);
        return ResponseEntity.ok(saleResponses);
    }

    @Operation(summary = "Find sales by Client", description = "Retrieves a paginated list of sales by client.", responses = {
        @ApiResponse(responseCode = "200", description = "Sales found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SaleResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "No sales found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @GetMapping("/list-by-client/{id}")
    public ResponseEntity<Page<SaleListDTO>> findByClient(@PathVariable Long clientId, @PageableDefault(size = 30, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Sale> sales = saleService.findByClient(clientId, pageable);
        Page<SaleListDTO> saleResponses = sales.map(SaleMapper::toList);
        return ResponseEntity.ok(saleResponses);
    }

    @Operation(summary = "Update an existing sale", description = "Update an existing sale with the provided details", responses = {
        @ApiResponse(responseCode = "200", description = "Sale updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SaleResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Sale not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @PutMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> update(@PathVariable Long id, @Valid @RequestBody SaleRequestDTO saleRequestDTO) {
        Sale updatedSale = saleService.update(id, saleRequestDTO);
        SaleResponseDTO saleResponse = SaleMapper.toResponse(updatedSale);
        return ResponseEntity.ok(saleResponse);
    }

}
