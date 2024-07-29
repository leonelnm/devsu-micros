package com.devsu.cliente_persona.cliente.app;

import com.devsu.cliente_persona.cliente.infra.adapters.MessageProducer;
import com.devsu.commons.infra.messaging.OperationConstants;
import com.devsu.commons.infra.messaging.dto.CuentaMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ColasTestController {

    @Autowired
    private MessageProducer messageProducerCliente;

    @GetMapping("/colas")
    public void sendMessage(@RequestParam long cuentaid) {
        CuentaMessage msg = new CuentaMessage(OperationConstants.CUENTA_ELIMINAR, cuentaid);

        messageProducerCliente.sendMessageCuenta(msg);
    }

}
