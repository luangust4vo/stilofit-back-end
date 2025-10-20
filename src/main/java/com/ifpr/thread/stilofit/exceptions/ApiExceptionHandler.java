package com.ifpr.thread.stilofit.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorMessage> handleValidation(
                        MethodArgumentNotValidException ex,
                        HttpServletRequest request) {

                String message = ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                                .findFirst()
                                .orElse("Erro de validação");

                ErrorMessage error = new ErrorMessage(request, HttpStatus.BAD_REQUEST, message);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        @ExceptionHandler(CpfAlreadyRegisteredException.class)
        public ResponseEntity<ErrorMessage> handleCpfAlreadyRegistered(
                        CpfAlreadyRegisteredException ex,
                        HttpServletRequest request) {

                log.error("Conflito de CPF: {}", ex.getMessage());
                ErrorMessage error = new ErrorMessage(
                                request,
                                HttpStatus.CONFLICT,
                                ex.getMessage());
                return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        }

        @ExceptionHandler(ProfessionalRegisterAlreadyExistsException.class)
        public ResponseEntity<ErrorMessage> handleProfessionalRegisterAlreadyExists(
                        ProfessionalRegisterAlreadyExistsException ex,
                        HttpServletRequest request) {

                log.error("Conflito de Registro Profissional: {}", ex.getMessage());
                ErrorMessage error = new ErrorMessage(
                                request,
                                HttpStatus.CONFLICT,
                                ex.getMessage());
                return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        }

       @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<ErrorMessage> handleNotFoundException(
                        NotFoundException ex,
                        HttpServletRequest request) {

                log.error("Não encontrado: {}", ex.getMessage());
                ErrorMessage error = new ErrorMessage(
                                request,
                                HttpStatus.NOT_FOUND,
                                ex.getMessage());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(NotBlankException.class)
        public ResponseEntity<ErrorMessage> handleNotBlankException(
                        NotBlankException ex,
                        HttpServletRequest request) {

                log.error("Não pode ser nulo: {}", ex.getMessage());
                ErrorMessage error = new ErrorMessage(
                                request,
                                HttpStatus.BAD_REQUEST,
                                ex.getMessage());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
}