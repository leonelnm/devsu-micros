package com.devsu.cliente_persona.cliente.infra;

public record ClienteInDTO(String nombre, String direccion, String telefono, String contrasena, Long clienteid, boolean estado) {
}

