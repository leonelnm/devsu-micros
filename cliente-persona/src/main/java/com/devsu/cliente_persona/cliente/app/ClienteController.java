package com.devsu.cliente_persona.cliente.app;

import com.devsu.commons.DevsuCrudController;
import com.devsu.cliente_persona.cliente.domain.ClienteService;
import com.devsu.cliente_persona.cliente.infra.ClienteInDTO;
import com.devsu.cliente_persona.cliente.infra.ClienteOutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController implements DevsuCrudController<ClienteInDTO, ClienteOutDTO, Long> {

    @Autowired
    private ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ClienteOutDTO create(@RequestBody ClienteInDTO entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    @Override
    public ClienteOutDTO update(@PathVariable Long id, @RequestBody ClienteInDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping
    @Override
    public List<ClienteOutDTO> findAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public ClienteOutDTO findById(@PathVariable Long id) {
        return service.getById(id);
    }
}
