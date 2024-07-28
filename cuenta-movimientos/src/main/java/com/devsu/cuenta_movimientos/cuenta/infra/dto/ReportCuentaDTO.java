package com.devsu.cuenta_movimientos.cuenta.infra.dto;

import com.devsu.cuenta_movimientos.cuenta.infra.TipoCuenta;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReportCuentaDTO(LocalDate fecha, String cliente, String numeroCuenta, TipoCuenta tipo,
                              BigDecimal saldoInicial, BigDecimal saldoDisponible, boolean estado,
                              BigDecimal movimiento) {
}
