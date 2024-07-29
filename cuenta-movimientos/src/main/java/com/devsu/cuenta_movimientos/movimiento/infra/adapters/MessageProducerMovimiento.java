package com.devsu.cuenta_movimientos.movimiento.infra.adapters;

import com.devsu.commons.infra.messaging.MessagingConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerMovimiento {

    private final RabbitTemplate rabbitTemplate;

    public MessageProducerMovimiento(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(MessagingConstants.QUEUE_CLIENTE, message);
    }

}
