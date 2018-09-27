package com.ggomez.simplemq.conejo;

<<<<<<< HEAD
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
=======
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "conejo-queue")
public class ConejoReceiver {
    @RabbitHandler
    public void recibir(String in) {
        System.out.println("Recibido '" + in + "'");
>>>>>>> 9a0339c807cd45f42d056f70cba23fa81ab753cb
    }
}
