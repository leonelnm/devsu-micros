package com.devsu.cuenta_movimientos.movimiento.infra;

import com.devsu.cuenta_movimientos.movimiento.domain.MovimientoRepository;
import com.devsu.cuenta_movimientos.movimiento.domain.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository repository;

    @Override
    public List<MovimientoDTO> getAll() {
        return List.of();
    }

    @Override
    public MovimientoDTO getById(Long aLong) {
        return null;
    }

    @Override
    public MovimientoDTO save(MovimientoDTO movimientoDTO) {
        return null;
    }

    @Override
    public MovimientoDTO update(Long id, MovimientoDTO movimientoDTO) {
        return null;
    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
