package com.devsu.cliente_persona.cliente.infra;

import com.devsu.cliente_persona.cliente.domain.Cliente;
import com.devsu.cliente_persona.cliente.domain.ClienteRepository;
import com.devsu.cliente_persona.cliente.domain.ClienteService;
import com.devsu.cliente_persona.cliente.infra.mapper.ClienteInMapper;
import com.devsu.cliente_persona.cliente.infra.mapper.ClienteOutMapper;
import com.devsu.commons.exception.EntidadNoEncontradaException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    private final ClienteInMapper inMapper;
    private final ClienteOutMapper outMapper;

    public ClienteServiceImpl(ClienteRepository repository, ClienteInMapper inMapper, ClienteOutMapper outMapper) {
        this.repository = repository;
        this.inMapper = inMapper;
        this.outMapper = outMapper;
    }


    @Override
    public List<ClienteOutDTO> getAll() {
        return repository.findAll().stream().map(outMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ClienteOutDTO getById(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException(ClienteErrorMessages.NO_EXISTE_CLIENTE, id));

        return outMapper.toDto(cliente);
    }

    @Override
    public ClienteOutDTO save(ClienteInDTO clienteInDTO) {
        Cliente cliente = inMapper.toEntity(clienteInDTO);
        repository.save(cliente);
        return outMapper.toDto(repository.save(cliente));
    }

    @Override
    public ClienteOutDTO update(Long id, ClienteInDTO clienteInDTO) {

        Cliente cliente = repository.findById(id)
                .map(c -> {
                    Cliente updated = inMapper.toEntity(clienteInDTO);
                    updated.setId(c.getId());
                    repository.save(updated);
                    return updated;
                })
                .orElseThrow(() -> new EntidadNoEncontradaException(ClienteErrorMessages.NO_EXISTE_CLIENTE, id));

        return outMapper.toDto(cliente);
    }

    @Override
    public void delete(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException(ClienteErrorMessages.NO_EXISTE_CLIENTE, id));

        // TODO http desactivar cuenta
        repository.delete(cliente);
        // TODO cola borrar cuenta

    }
}
