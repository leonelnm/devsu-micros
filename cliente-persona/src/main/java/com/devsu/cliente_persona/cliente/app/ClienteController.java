package com.devsu.cliente_persona.cliente.app;

import com.devsu.DevsuCrudController;
import com.devsu.cliente_persona.cliente.domain.ClienteService;
import com.devsu.cliente_persona.cliente.infra.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController implements DevsuCrudController<ClienteDTO> {

    @Autowired
    private ClienteService service;

    @PostMapping
    @Override
    public ClienteDTO create(ClienteDTO entity) {
        return service.save(entity);
    }

    @PutMapping
    @Override
    public ClienteDTO update(ClienteDTO entity) {
        return service.update(entity);
    }

    @DeleteMapping
    @Override
    public void delete(ClienteDTO entity) {
        service.delete(entity.clienteid());
    }

    @GetMapping
    @Override
    public List<ClienteDTO> findAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public ClienteDTO findById(Long id) {
        return service.getById(id);
    }
}
