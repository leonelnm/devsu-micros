package com.devsu.cuenta_movimientos.cuenta.infra;

import com.devsu.cuenta_movimientos.cuenta.domain.Cuenta;
import com.devsu.cuenta_movimientos.cuenta.domain.CuentaRepository;
import com.devsu.cuenta_movimientos.cuenta.domain.CuentaService;
import com.devsu.cuenta_movimientos.cuenta.infra.adapters.ClientePersonaProxy;
import com.devsu.commons.exception.EntidadNoEncontradaException;
import com.devsu.commons.exception.RegistroDuplicadoException;
import com.devsu.cuenta_movimientos.cuenta.infra.dto.CuentaDTO;
import com.devsu.cuenta_movimientos.cuenta.infra.exception.SaldoInsuficienteException;
import com.devsu.cuenta_movimientos.movimiento.infra.TipoMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired private ClientePersonaProxy clientePersonaProxy;
    @Autowired private CuentaRepository repository;
    @Autowired private CuentaMapper mapper;


    @Override
    public List<CuentaDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CuentaDTO getById(Long aLong) {
        return null;
    }

    @Override
    public CuentaDTO save(CuentaDTO cuentaDTO) {

        if(repository.existsByNumero(cuentaDTO.numero())) {
            throw new RegistroDuplicadoException(CuentaErrorMessages.DUPLICADO_EXISTE_NUMERO_CUENTA, cuentaDTO.numero());
        }

        if(!clientePersonaProxy.clienteExiste(cuentaDTO.clienteid())){
            throw new EntidadNoEncontradaException("El cliente no existe");
        }

        Cuenta cuenta = mapper.toEntity(cuentaDTO);
        repository.save(cuenta);
        return mapper.toDto(cuenta);
    }

    @Override
    public CuentaDTO update(Long id, CuentaDTO cuentaDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsByNumero(String numero) {
        return repository.existsByNumero(numero);
    }

    @Override
    public Cuenta getByNumeroCuenta(String numero) {
        Cuenta cuenta = repository.findByNumero(numero);
        if(cuenta == null){
            throw new EntidadNoEncontradaException(CuentaErrorMessages.NO_EXISTE_CUENTA, numero);
        }
        return cuenta;
    }

    @Override
    public void updateSaldoConMovimiento(@NonNull Cuenta cuenta, @NonNull TipoMovimiento tipoMovimiento, @NonNull BigDecimal valor) {
        if(tipoMovimiento == TipoMovimiento.RETIRO) {
            valor = valor.abs().negate();
        }else if(tipoMovimiento == TipoMovimiento.DEPOSITO) {
            valor = valor.abs();
        }

        BigDecimal nuevoSaldo = cuenta.getSaldo().add(valor);

        if(nuevoSaldo.compareTo(BigDecimal.ZERO) < 0){
            throw new SaldoInsuficienteException();
        }

        cuenta.setSaldo(nuevoSaldo);
        repository.save(cuenta);
    }

    @Override
    public List<Cuenta> getCuentasByCliente(Long clienteid) {
        return repository.findAllByClienteid(clienteid);
    }

    @Override
    public void eliminarByCliente(Long clienteid) {
        repository.findAllByClienteid(clienteid).forEach(repository::delete);
    }
}
