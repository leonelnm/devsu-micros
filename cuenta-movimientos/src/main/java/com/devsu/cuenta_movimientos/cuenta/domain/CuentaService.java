package com.devsu.cuenta_movimientos.cuenta.domain;

import com.devsu.DevsuService;
import com.devsu.cuenta_movimientos.cuenta.infra.CuentaDTO;

public interface CuentaService extends DevsuService<CuentaDTO, Cuenta, Long> {
}
