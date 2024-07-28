package com.devsu.cuenta_movimientos.cuenta.infra;

public class CuentaErrorMessages {

    public static final String NO_EXISTE_CUENTA = "La cuenta no existe. Cuenta: %s";
    public static final String DUPLICADO_EXISTE_NUMERO_CUENTA = "La cuenta ya existe. Cuenta: %s";
    public static final String SALDO_NO_DISPONIBLE = "Saldo no disponible";

    private CuentaErrorMessages(){
        throw new IllegalStateException("No instanciar CuentaErrorMessages");
    }

}
