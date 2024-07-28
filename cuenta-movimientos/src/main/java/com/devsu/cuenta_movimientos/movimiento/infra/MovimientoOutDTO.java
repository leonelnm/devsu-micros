package com.devsu.cuenta_movimientos.movimiento.infra;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MovimientoOutDTO(Long id, LocalDateTime fecha, TipoMovimiento tipo, BigDecimal valor, BigDecimal saldoDisponible, BigDecimal saldoInicial, String numeroCuenta) {
}
