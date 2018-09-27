package com.ggomez.simplemq.conejo;

<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConejoSender implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ConejoSender.class);

    @Autowired
    private RabbitTemplate template;

    public ConejoSender(RabbitTemplate template) {
        this.template = template;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.debug("Enviando mensaje...");
        template.convertAndSend(ConejoApplication.topicExchangeName, ConejoApplication.routingKey, "A darle atomos!");
    }
}

=======
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class ConejoSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void enviar() {
        String message = "Mensaje simple!";
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
>>>>>>> 9a0339c807cd45f42d056f70cba23fa81ab753cb
