package com.devsu.cliente_persona.cliente.domain;

import com.devsu.commons.DevsuService;
import com.devsu.cliente_persona.cliente.infra.ClienteInDTO;
import com.devsu.cliente_persona.cliente.infra.ClienteOutDTO;

public interface ClienteService extends DevsuService<ClienteInDTO, ClienteOutDTO, Long> {
}
