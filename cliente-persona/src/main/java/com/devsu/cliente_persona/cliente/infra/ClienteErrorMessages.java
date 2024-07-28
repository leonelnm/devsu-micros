package com.devsu.cliente_persona.cliente.infra;

public class ClienteErrorMessages {

    private ClienteErrorMessages() {
        throw new IllegalStateException("No instanciar ClienteErrorMessages");
    }

    public static final String NO_EXISTE_CLIENTE = "El cliente no existe. Id: %d";

}
