package com.devsu.cuenta_movimientos;

import com.devsu.cuenta_movimientos.cuenta.infra.adapters.ClientePersonaProxy;
import com.devsu.cuenta_movimientos.cuenta.infra.dto.ClienteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class CuentaMovimientosApplicationTests {

	@MockBean
    private ClientePersonaProxy clientePersonaProxy;

    @BeforeEach
    public void setUp() {

        Mockito.when(clientePersonaProxy.clienteExiste(Mockito.anyLong())).thenReturn(true);
        Mockito.when(clientePersonaProxy.getCliente(Mockito.anyLong()))
                .thenReturn(new ClienteDTO("Juan", "Calle", "123456789", 1L, true));
    }


}
