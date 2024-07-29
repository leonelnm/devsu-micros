package com.devsu.cuenta_movimientos.cuenta.infra.adapters;

import com.devsu.commons.infra.messaging.MessagingConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerCuenta {

    private final RabbitTemplate rabbitTemplate;

    public MessageProducerCuenta(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(MessagingConstants.QUEUE_CLIENTE, message);
    }

}
