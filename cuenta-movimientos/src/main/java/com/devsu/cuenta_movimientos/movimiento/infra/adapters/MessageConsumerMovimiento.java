package com.devsu.cuenta_movimientos.movimiento.infra.adapters;

import com.devsu.commons.infra.messaging.MessagingConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerMovimiento {

    private static final Logger logger = LoggerFactory.getLogger(MessageConsumerMovimiento.class);

    @RabbitListener(queues = MessagingConstants.QUEUE_MOVIMIENTO)
    public void receivedMessage(String message) {
        logger.info("[colas] Received message: {}", message);
    }

}
