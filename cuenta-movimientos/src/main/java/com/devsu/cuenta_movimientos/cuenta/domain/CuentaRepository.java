package com.devsu.cuenta_movimientos.cuenta.domain;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends ListCrudRepository<Cuenta, Long> {

    boolean existsByNumero(String numero);

    Cuenta findByNumero(String numero);

    List<Cuenta> findAllByClienteid(Long clienteid);
}
