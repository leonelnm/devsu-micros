package com.devsu.cuenta_movimientos.movimiento.domain;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends ListCrudRepository<Movimiento, Long> {
}
