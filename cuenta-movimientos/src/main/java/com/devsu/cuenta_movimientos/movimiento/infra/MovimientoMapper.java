package com.devsu.cuenta_movimientos.movimiento.infra;

import com.devsu.commons.DevsuMapper;
import com.devsu.cuenta_movimientos.movimiento.domain.Movimiento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovimientoMapper extends DevsuMapper<MovimientoDTO, Movimiento> {
}
