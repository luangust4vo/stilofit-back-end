package com.ifpr.thread.stilofit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProfessionalRegisterAlreadyExistsException extends RuntimeException {
    public ProfessionalRegisterAlreadyExistsException(String message) {
        super(message);
    }
}
