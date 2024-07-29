package com.devsu.cuenta_movimientos.infra.config;

import com.devsu.commons.infra.messaging.MessagingConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CuentaMovimientoRabbitMQConfig {

    @Bean
    public Queue queueCuenta() {
        return new Queue(MessagingConstants.QUEUE_CUENTA, false);
    }

    @Bean
    public Queue queueMovimiento() {
        return new Queue(MessagingConstants.QUEUE_MOVIMIENTO, false);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter jsonMessageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter);
        return template;
    }

}
