package com.ggomez.simplemq.conejo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "conejo-queue")
public class ConejoReceiver {
    @RabbitHandler
    public void recibir(String in) {
        System.out.println("Recibido '" + in + "'");
    }
}
