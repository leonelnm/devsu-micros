package com.devsu.cuenta_movimientos.cuenta.infra.adapters;

import com.devsu.commons.infra.messaging.MessagingConstants;
import com.devsu.commons.infra.messaging.OperationConstants;
import com.devsu.commons.infra.messaging.dto.CuentaMessage;
import com.devsu.cuenta_movimientos.cuenta.domain.CuentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerCuenta {

    private static final Logger logger = LoggerFactory.getLogger(MessageConsumerCuenta.class);

    private final CuentaService cuentaService;

    public MessageConsumerCuenta(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @RabbitListener(queues = MessagingConstants.QUEUE_CUENTA)
    public void receivedMessage(CuentaMessage message) {
        logger.info("[cola-cuenta] Received message: {}", message);

        if (message.getOperation().equals(OperationConstants.CUENTA_ELIMINAR)) {
            cuentaService.eliminarByCliente(message.getClienteid());
        }

    }

}
