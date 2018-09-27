package com.ggomez.simplemq.conejo;

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

