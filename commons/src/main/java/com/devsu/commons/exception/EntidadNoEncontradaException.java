package com.devsu.commons.exception;

public class EntidadNoEncontradaException extends RuntimeException {

    public EntidadNoEncontradaException(String message) {
        super(message);
    }

    public EntidadNoEncontradaException(String message, Long id) {
        super(String.format(message, id));
    }

    public EntidadNoEncontradaException(String message, String s) {
        super(String.format(message, s));
    }
}
