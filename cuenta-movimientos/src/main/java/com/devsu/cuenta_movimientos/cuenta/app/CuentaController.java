package com.devsu.cuenta_movimientos.cuenta.app;

import com.devsu.commons.DevsuCrudController;
import com.devsu.cuenta_movimientos.cuenta.domain.CuentaService;
import com.devsu.cuenta_movimientos.cuenta.infra.CuentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController implements DevsuCrudController<CuentaDTO, CuentaDTO, Long> {

    @Autowired
    private CuentaService service;

    @PostMapping
    @Override
    public CuentaDTO create(@RequestBody CuentaDTO entity) {
        return service.save(entity);
    }

    @PutMapping
    @Override
    public CuentaDTO update(Long id, CuentaDTO entity) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable Long id) {

    }

    @GetMapping
    @Override
    public List<CuentaDTO> findAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public CuentaDTO findById(Long id) {
        return null;
    }
}
