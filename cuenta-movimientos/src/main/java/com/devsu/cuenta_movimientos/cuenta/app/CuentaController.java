package com.devsu.cuenta_movimientos.cuenta.app;

import com.devsu.DevsuCrudController;
import com.devsu.cuenta_movimientos.cuenta.domain.CuentaService;
import com.devsu.cuenta_movimientos.cuenta.infra.CuentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController implements DevsuCrudController<CuentaDTO> {

    @Autowired
    private CuentaService service;

    @PostMapping
    @Override
    public CuentaDTO create(CuentaDTO entity) {
        return null;
    }

    @PutMapping
    @Override
    public CuentaDTO update(CuentaDTO entity) {
        return null;
    }

    @DeleteMapping
    @Override
    public void delete(CuentaDTO entity) {

    }

    @GetMapping
    @Override
    public List<CuentaDTO> findAll() {
        return List.of();
    }

    @GetMapping("/{id}")
    @Override
    public CuentaDTO findById(Long id) {
        return null;
    }
}
