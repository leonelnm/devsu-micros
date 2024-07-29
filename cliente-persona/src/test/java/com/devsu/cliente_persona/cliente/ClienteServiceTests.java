package com.devsu.cliente_persona.cliente;

import com.devsu.cliente_persona.cliente.domain.Cliente;
import com.devsu.cliente_persona.cliente.domain.ClienteRepository;
import com.devsu.cliente_persona.cliente.infra.ClienteOutDTO;
import com.devsu.cliente_persona.cliente.infra.ClienteServiceImpl;
import com.devsu.cliente_persona.cliente.infra.adapters.MessageProducer;
import com.devsu.cliente_persona.cliente.infra.mapper.ClienteInMapper;
import com.devsu.cliente_persona.cliente.infra.mapper.ClienteOutMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class ClienteServiceTests {

    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private MessageProducer messageProducerCliente;

    @Autowired
    private ClienteInMapper clienteInMapper;

    @Autowired
    private ClienteOutMapper clienteOutMapper;

    private ClienteServiceImpl clienteService;

    @BeforeEach
    public void setUp() {
        clienteService = new ClienteServiceImpl(clienteRepository, clienteInMapper, clienteOutMapper, messageProducerCliente);
    }

    @Test
    public void testGetClienteByIdOK() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Test Apellido");

        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        ClienteOutDTO clienteEncontrado = clienteService.getById(1L);

        Assertions.assertEquals("Test Apellido", clienteEncontrado.nombre());
    }


}
