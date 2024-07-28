package com.devsu.cuenta_movimientos.cuenta.infra.exception;

import com.devsu.cuenta_movimientos.cuenta.infra.CuentaErrorMessages;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException() {
        super(CuentaErrorMessages.SALDO_NO_DISPONIBLE);
    }
}
