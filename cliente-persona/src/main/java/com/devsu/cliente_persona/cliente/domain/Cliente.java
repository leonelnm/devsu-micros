package com.devsu.cliente_persona.cliente.domain;

import com.devsu.cliente_persona.persona.domain.Persona;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "clienteid")
public class Cliente extends Persona {

    private String contrasenia;

    @Column(columnDefinition = "boolean default true")
    private Boolean estado;

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
