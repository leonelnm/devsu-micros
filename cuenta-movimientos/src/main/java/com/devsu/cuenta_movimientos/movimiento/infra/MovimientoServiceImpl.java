package com.devsu.cuenta_movimientos.movimiento.infra;

import com.devsu.cuenta_movimientos.cuenta.domain.Cuenta;
import com.devsu.cuenta_movimientos.cuenta.domain.CuentaService;
import com.devsu.cuenta_movimientos.movimiento.domain.Movimiento;
import com.devsu.cuenta_movimientos.movimiento.domain.MovimientoRepository;
import com.devsu.cuenta_movimientos.movimiento.domain.MovimientoService;
import com.devsu.cuenta_movimientos.movimiento.infra.mapper.MovimientoInMapper;
import com.devsu.cuenta_movimientos.movimiento.infra.mapper.MovimientoOutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired private MovimientoRepository repository;
    @Autowired private CuentaService cuentaService;
    @Autowired private MovimientoInMapper mapperIn;
    @Autowired private MovimientoOutMapper mapperOut;

    @Override
    public List<MovimientoOutDTO> getAll() {
        return List.of();
    }

    @Override
    public MovimientoOutDTO getById(Long aLong) {
        return null;
    }

    @Override
    @Transactional
    public MovimientoOutDTO save(MovimientoInDTO movimientoDTO) {
        Cuenta cuenta = cuentaService.getByNumeroCuenta(movimientoDTO.numeroCuenta());
        BigDecimal saldoInicial = cuenta.getSaldo();
        cuentaService.updateSaldoConMovimiento(cuenta, movimientoDTO.tipo(), movimientoDTO.valor());

        Movimiento movimiento = saveMovimiento(movimientoDTO, saldoInicial, cuenta);
        return mapperOut.toDto(movimiento);
    }

    private Movimiento saveMovimiento(MovimientoInDTO movimientoDTO, BigDecimal saldoInicial, Cuenta cuenta) {
        Movimiento movimiento = mapperIn.toEntity(movimientoDTO);
        movimiento.setSaldoInicial(saldoInicial);
        movimiento.setSaldoDisponible(cuenta.getSaldo());
        movimiento.setCuenta(cuenta);
        repository.save(movimiento);
        return movimiento;
    }

    @Override
    public MovimientoOutDTO update(Long id, MovimientoInDTO movimientoDTO) {
        return null;
    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
