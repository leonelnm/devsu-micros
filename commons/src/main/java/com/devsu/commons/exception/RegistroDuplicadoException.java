package com.devsu.commons.exception;

public class RegistroDuplicadoException extends RuntimeException{

    public RegistroDuplicadoException(String duplicadoExisteNumeroCuenta, String numero) {
        super(String.format(duplicadoExisteNumeroCuenta, numero));
    }
}
