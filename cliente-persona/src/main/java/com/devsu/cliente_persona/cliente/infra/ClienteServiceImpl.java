package com.devsu.cliente_persona.cliente.infra;

import com.devsu.cliente_persona.cliente.domain.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Override
    public List<ClienteDTO> getAll() {
        return List.of();
    }

    @Override
    public ClienteDTO getById(Long aLong) {
        return null;
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        return null;
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
