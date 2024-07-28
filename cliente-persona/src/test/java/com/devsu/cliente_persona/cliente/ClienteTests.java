package com.devsu.cliente_persona.cliente;

import com.devsu.cliente_persona.ClientePersonaApplicationTests;
import com.intuit.karate.junit5.Karate;

public class ClienteTests extends ClientePersonaApplicationTests {

    @Karate.Test
    Karate testAll() {
        return Karate.run("src/test/resources/features/cliente.feature");
    }

}
