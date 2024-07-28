package com.devsu.cliente_persona.cliente.infra;

import com.devsu.DevsuMapper;
import com.devsu.cliente_persona.cliente.domain.Cliente;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
public interface ClienteMapper extends DevsuMapper<ClienteDTO, Cliente> {
}
