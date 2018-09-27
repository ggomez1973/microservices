package com.ggomez.simplemq.conejo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@RabbitListener(queues = "conejo-queue")
@Component
public class ConejoReceiver {
    private static final Logger logger = LoggerFactory.getLogger(ConejoReceiver.class);

   // @RabbitHandler
    public void recibirMensaje(String message) {
        logger.debug("Received <" + message + ">");
    }
}
