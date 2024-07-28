package com.devsu.cuenta_movimientos.movimiento.infra.mapper;

import com.devsu.commons.DevsuMapper;
import com.devsu.cuenta_movimientos.movimiento.domain.Movimiento;
import com.devsu.cuenta_movimientos.movimiento.infra.MovimientoInDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovimientoInMapper extends DevsuMapper<MovimientoInDTO, Movimiento> {
}
