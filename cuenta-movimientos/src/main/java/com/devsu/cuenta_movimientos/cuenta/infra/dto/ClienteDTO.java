package com.devsu.cuenta_movimientos.cuenta.infra.dto;

public record ClienteDTO(String nombre, String direccion, String telefono, Long clienteid, boolean estado) {
}