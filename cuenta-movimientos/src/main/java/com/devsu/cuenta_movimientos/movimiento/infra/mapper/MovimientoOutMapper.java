package com.devsu.cuenta_movimientos.movimiento.infra.mapper;

import com.devsu.commons.DevsuMapper;
import com.devsu.cuenta_movimientos.movimiento.domain.Movimiento;
import com.devsu.cuenta_movimientos.movimiento.infra.MovimientoOutDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovimientoOutMapper extends DevsuMapper<MovimientoOutDTO, Movimiento> {
}
