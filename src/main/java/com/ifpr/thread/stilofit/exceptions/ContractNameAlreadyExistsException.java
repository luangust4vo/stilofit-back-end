package com.ifpr.thread.stilofit.exceptions;

public class ContractNameAlreadyExistsException extends RuntimeException {
    public ContractNameAlreadyExistsException(String message) {
        super(message);
    }
}