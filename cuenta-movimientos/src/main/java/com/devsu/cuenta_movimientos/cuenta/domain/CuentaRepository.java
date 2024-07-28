package com.devsu.cuenta_movimientos.cuenta.domain;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends ListCrudRepository<Cuenta, Long> {

    boolean existsByNumero(String numero);

    Cuenta findByNumero(String numero);
}
