package com.devsu.cuenta_movimientos.cuenta.infra;

import java.math.BigDecimal;

public record CuentaDTO(Long id, String numero, TipoCuenta tipo, BigDecimal saldo, Boolean estado, Long clienteid) {
}
