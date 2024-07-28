package com.devsu.commons.dto;

public record ErrorResponse(
        int status,
        String error,
        String message,
        long timestamp) {

    // Constructor personalizado para inicializar timestamp
    public ErrorResponse(int status, String error, String message) {
        this(status, error, message, System.currentTimeMillis());
    }
}

