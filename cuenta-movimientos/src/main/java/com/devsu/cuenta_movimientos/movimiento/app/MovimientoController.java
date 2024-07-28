package com.devsu.cuenta_movimientos.movimiento.app;

import com.devsu.DevsuCrudController;
import com.devsu.cuenta_movimientos.movimiento.domain.MovimientoService;
import com.devsu.cuenta_movimientos.movimiento.infra.MovimientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController implements DevsuCrudController<MovimientoDTO> {

    @Autowired
    private MovimientoService service;

    @PostMapping
    @Override
    public MovimientoDTO create(MovimientoDTO entity) {
        return service.save(entity);
    }

    @PutMapping
    @Override
    public MovimientoDTO update(MovimientoDTO entity) {
        return service.update(entity);
    }

    @DeleteMapping
    @Override
    public void delete(MovimientoDTO entity) {
        service.delete(entity.id());
    }

    @GetMapping
    @Override
    public List<MovimientoDTO> findAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public MovimientoDTO findById(Long id) {
        return service.getById(id);
    }
}
