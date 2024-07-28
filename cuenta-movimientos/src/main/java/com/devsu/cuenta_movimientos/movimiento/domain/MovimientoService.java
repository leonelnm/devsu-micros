package com.devsu.cuenta_movimientos.movimiento.domain;

import com.devsu.commons.DevsuService;
import com.devsu.cuenta_movimientos.movimiento.infra.MovimientoInDTO;
import com.devsu.cuenta_movimientos.movimiento.infra.MovimientoOutDTO;

public interface MovimientoService extends DevsuService<MovimientoInDTO, MovimientoOutDTO, Long> {

}
