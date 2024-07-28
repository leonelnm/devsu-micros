package com.devsu.cliente_persona.cliente.domain;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends ListCrudRepository<Cliente, Long> {
}
