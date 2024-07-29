package com.devsu.cliente_persona.cliente.infra.adapters;

import com.devsu.commons.exception.GlobalExceptionHandler;
import com.devsu.commons.infra.messaging.MessagingConstants;
import com.devsu.commons.infra.messaging.dto.CuentaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);


    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageCuenta(CuentaMessage message) {
        logger.info("Sending message to queue {}. Message: {}", MessagingConstants.QUEUE_CUENTA, message);
        rabbitTemplate.convertAndSend(MessagingConstants.QUEUE_CUENTA, message);
    }

}
