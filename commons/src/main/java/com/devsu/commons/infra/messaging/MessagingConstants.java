package com.devsu.commons.infra.messaging;

public class MessagingConstants {

    public static final String QUEUE_CLIENTE = "queue-cliente";
    public static final String QUEUE_CUENTA = "queue-cuenta";
    public static final String QUEUE_MOVIMIENTO = "queue-movimiento";


    private MessagingConstants() {
        throw new IllegalStateException("Utility class");
    }

}
