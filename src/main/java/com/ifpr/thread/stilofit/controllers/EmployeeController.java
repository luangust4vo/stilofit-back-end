package com.ifpr.thread.stilofit.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifpr.thread.stilofit.dto.EmployeeRequestDTO;
import com.ifpr.thread.stilofit.dto.EmployeeResponseDTO;
import com.ifpr.thread.stilofit.dto.mapper.EmployeeMapper;
import com.ifpr.thread.stilofit.exceptions.ErrorMessage;
import com.ifpr.thread.stilofit.models.Employee;
import com.ifpr.thread.stilofit.services.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Operation(summary = "Create a new client", description = "Creates a new client with the provided details.", responses = {
        @ApiResponse(responseCode = "201", description = "Employee created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> create(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = employeeService.create(employeeRequestDTO);
        EmployeeResponseDTO employeeResponse = EmployeeMapper.toResponseDTO(employee);
        return ResponseEntity.status(201).body(employeeResponse);
    }
}
