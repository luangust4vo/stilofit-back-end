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

import com.ifpr.thread.stilofit.dto.ClientRequestDTO;
import com.ifpr.thread.stilofit.dto.ClientResponseDTO;
import com.ifpr.thread.stilofit.dto.list.ClientListDTO;
import com.ifpr.thread.stilofit.dto.mapper.ClientMapper;
import com.ifpr.thread.stilofit.exceptions.ErrorMessage;
import com.ifpr.thread.stilofit.services.ClientService;
import com.ifpr.thread.stilofit.models.Client;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
@CrossOrigin("http://localhost:5173")
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Create a new client", description = "Creates a new client with the provided details.", responses = {
        @ApiResponse(responseCode = "201", description = "Client created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@Valid @RequestBody ClientRequestDTO clientRequestDTO) {
        Client client = clientService.create(clientRequestDTO);
        ClientResponseDTO clientResponse = ClientMapper.toResponse(client);
        return ResponseEntity.status(201).body(clientResponse);
    }

    @Operation(summary = "Find client by ID", description = "Retrieves a client by their unique ID.", responses = {
        @ApiResponse(responseCode = "200", description = "Client found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Client not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),})
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        ClientResponseDTO clientResponse = ClientMapper.toResponse(client);
        return ResponseEntity.ok(clientResponse);
    }

    @Operation(summary = "Find all clients", description = "Retrieves a paginated list of all clients.", responses = {
        @ApiResponse(responseCode = "200", description = "Clients found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "No clients found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @GetMapping("/list-all-clients")
    public ResponseEntity<Page<ClientListDTO>> findAll(@PageableDefault(size = 30, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Client> clients = clientService.findAll(pageable);
        Page<ClientListDTO> clientResponses = clients.map(ClientMapper::toList);
        return ResponseEntity.ok(clientResponses);
    }

    @Operation(summary = "Update an existing client", description = "Update an existing client with the provided details", responses = {
        @ApiResponse(responseCode = "200", description = "Client updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Client not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})
    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> update(@PathVariable Long id, @RequestBody ClientRequestDTO clientRequestDTO) {
        Client updatedClient = clientService.update(id, clientRequestDTO);
        ClientResponseDTO clientResponse = ClientMapper.toResponse(updatedClient);
        return ResponseEntity.ok(clientResponse);
    }

}
