package com.devsu.cuenta_movimientos.movimiento.infra;

import java.math.BigDecimal;

public record MovimientoInDTO(TipoMovimiento tipo, BigDecimal valor, String numeroCuenta) {
}
