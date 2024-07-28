package com.devsu.cuenta_movimientos.cuenta.infra;

import com.devsu.commons.DevsuMapper;
import com.devsu.cuenta_movimientos.cuenta.domain.Cuenta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CuentaMapper extends DevsuMapper<CuentaDTO, Cuenta> {
}
