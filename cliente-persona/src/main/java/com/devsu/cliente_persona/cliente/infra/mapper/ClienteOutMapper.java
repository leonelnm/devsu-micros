package com.devsu.cliente_persona.cliente.infra.mapper;

import com.devsu.commons.DevsuMapper;
import com.devsu.cliente_persona.cliente.domain.Cliente;
import com.devsu.cliente_persona.cliente.infra.ClienteOutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteOutMapper extends DevsuMapper<ClienteOutDTO, Cliente> {

    @Override
    @Mapping(target = "clienteid", source = "entity.id")
    ClienteOutDTO toDto(Cliente entity);


}
