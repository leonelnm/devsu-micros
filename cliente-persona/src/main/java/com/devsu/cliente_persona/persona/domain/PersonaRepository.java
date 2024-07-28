package com.devsu.cliente_persona.persona.domain;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends ListCrudRepository<Persona, Long> {
}
