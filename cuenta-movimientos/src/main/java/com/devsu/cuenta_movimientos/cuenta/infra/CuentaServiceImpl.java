package com.devsu.cuenta_movimientos.cuenta.infra;

import com.devsu.cuenta_movimientos.cuenta.domain.CuentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Override
    public List<CuentaDTO> getAll() {
        return List.of();
    }

    @Override
    public CuentaDTO getById(Long aLong) {
        return null;
    }

    @Override
    public CuentaDTO save(CuentaDTO cuentaDTO) {
        return null;
    }

    @Override
    public CuentaDTO update(CuentaDTO cuentaDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
