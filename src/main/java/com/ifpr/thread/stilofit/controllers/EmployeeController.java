package com.ifpr.thread.stilofit.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifpr.thread.stilofit.dto.ClientResponseDTO;
import com.ifpr.thread.stilofit.dto.EmployeeRequestDTO;
import com.ifpr.thread.stilofit.dto.EmployeeResponseDTO;
import com.ifpr.thread.stilofit.dto.list.EmployeeListDTO;
import com.ifpr.thread.stilofit.dto.mapper.ClientMapper;
import com.ifpr.thread.stilofit.dto.mapper.EmployeeMapper;
import com.ifpr.thread.stilofit.exceptions.ErrorMessage;
import com.ifpr.thread.stilofit.models.Client;
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

    @Operation(summary = "Find employee by ID", description = "Retrieves a employee by their unique ID.", responses = {
        @ApiResponse(responseCode = "200", description = "Employee found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Employee not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),})
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> findById(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        EmployeeResponseDTO employeeResponse = EmployeeMapper.toResponseDTO(employee);
        return ResponseEntity.ok(employeeResponse);
    }

    @Operation(summary = "Find all employees", description = "Retrieves a paginated list of all employees.", responses = {
        @ApiResponse(responseCode = "200", description = "Employees found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "No employees found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @GetMapping("/list-all-employees")
    public ResponseEntity<Page<EmployeeListDTO>> findAll(@PageableDefault(size = 30, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        Page<EmployeeListDTO> employeeResponses = employees.map(EmployeeMapper::toList);
        return ResponseEntity.ok(employeeResponses);
    }
}
