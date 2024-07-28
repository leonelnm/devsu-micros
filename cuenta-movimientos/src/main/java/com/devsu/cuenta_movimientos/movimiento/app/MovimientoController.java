package com.devsu.cuenta_movimientos.movimiento.app;

import com.devsu.commons.DevsuCrudController;
import com.devsu.cuenta_movimientos.movimiento.domain.MovimientoService;
import com.devsu.cuenta_movimientos.movimiento.infra.MovimientoInDTO;
import com.devsu.cuenta_movimientos.movimiento.infra.MovimientoOutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController implements DevsuCrudController<MovimientoInDTO, MovimientoOutDTO, Long> {

    @Autowired private MovimientoService service;

    @PostMapping
    @Override
    public MovimientoOutDTO create(@RequestBody MovimientoInDTO dto) {
        return service.save(dto);
    }

    @PutMapping
    @Override
    public MovimientoOutDTO update(Long id, MovimientoInDTO entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping
    @Override
    public List<MovimientoOutDTO> findAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public MovimientoOutDTO findById(Long id) {
        return service.getById(id);
    }
}
