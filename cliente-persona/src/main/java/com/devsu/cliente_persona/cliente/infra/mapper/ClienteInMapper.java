package com.devsu.cliente_persona.cliente.infra.mapper;

import com.devsu.commons.DevsuMapper;
import com.devsu.cliente_persona.cliente.domain.Cliente;
import com.devsu.cliente_persona.cliente.infra.ClienteInDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteInMapper extends DevsuMapper<ClienteInDTO, Cliente> {

    @Override
    @Mapping(target = "id", source = "dto.clienteid")
    Cliente toEntity(ClienteInDTO dto);
}
