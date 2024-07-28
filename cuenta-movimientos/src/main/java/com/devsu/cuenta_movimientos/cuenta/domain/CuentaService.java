package com.devsu.cuenta_movimientos.cuenta.domain;

import com.devsu.commons.DevsuService;
import com.devsu.cuenta_movimientos.cuenta.infra.CuentaDTO;
import com.devsu.cuenta_movimientos.movimiento.infra.TipoMovimiento;

import java.math.BigDecimal;

public interface CuentaService extends DevsuService<CuentaDTO, CuentaDTO, Long> {

    boolean existsByNumero(String numero);
    Cuenta getByNumeroCuenta(String numero);
    void updateSaldoConMovimiento(Cuenta cuenta, TipoMovimiento tipoMovimiento, BigDecimal valor);
}
