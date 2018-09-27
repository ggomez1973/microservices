package com.ggomez.simplemq.conejo;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("simple")
@Configuration
public class ConejoConfig {
    @Bean
    public Queue createQueue() {
        return new Queue("conejo-queue");
    }

    @Profile("receiver")
    @Bean
    public ConejoReceiver receiver() {
        return new ConejoReceiver();
    }

    @Profile("sender")
    @Bean
    public ConejoSender sender() {
        return new ConejoSender();
    }
}
