package com.devsu.cuenta_movimientos.cuenta.infra;

import com.devsu.cuenta_movimientos.cuenta.domain.Cuenta;
import com.devsu.cuenta_movimientos.cuenta.domain.CuentaRepository;
import com.devsu.cuenta_movimientos.cuenta.domain.CuentaService;
import com.devsu.cuenta_movimientos.cuenta.infra.adapters.ClientePersonaProxy;
import com.devsu.commons.exception.EntidadNoEncontradaException;
import com.devsu.commons.exception.RegistroDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired private ClientePersonaProxy clientePersonaProxy;
    @Autowired private CuentaRepository repository;
    @Autowired private CuentaMapper mapper;


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

        if(repository.existsByNumero(cuentaDTO.numero())) {
            throw new RegistroDuplicadoException("Ya existe una cuenta con ese numero");
        }

        if(!clientePersonaProxy.clienteExiste(cuentaDTO.clienteId())){
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
}
