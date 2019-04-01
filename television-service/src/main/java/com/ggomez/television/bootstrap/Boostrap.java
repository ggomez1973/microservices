package com.ggomez.television.bootstrap;

import com.ggomez.television.dtos.ChannelDTO;
import com.ggomez.television.dtos.SignalTypeDTO;
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
        SignalTypeDTO type = new SignalTypeDTO();
        type.setDescription("HD 4K");
        SignalTypeDTO s = service.save(type).block();
        System.out.println(s);

        service.save(ChannelDTO.builder()
        .name("Fox Sports Premiun")
        .gridNumber("1015")
        .type(s)
        .description("Aca pasan la Formula 1 con Tornello y el otro boludo.")
        .build()).block();
    }
}
