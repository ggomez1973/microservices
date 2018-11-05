package com.ggomez.television.bootstrap;

import com.ggomez.television.model.Channel;
import com.ggomez.television.model.SignalType;
import com.ggomez.television.service.TelevisionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Boostrap implements CommandLineRunner {
    private final TelevisionService service;

    public Boostrap(TelevisionService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        service.save(Channel.builder()
        .name("Fox Sports Premiun")
        .gridNumber("1015")
        .signalType(SignalType.HD)
        .description("Aca pasan la Formula 1 con Tornello y el otro boludo.")
        .build()).block();
    }
}
