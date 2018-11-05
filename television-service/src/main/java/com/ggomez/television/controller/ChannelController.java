package com.ggomez.television.controller;

import com.ggomez.television.model.Channel;
import com.ggomez.television.service.TelevisionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ChannelController {
    private final TelevisionService service;

    public ChannelController(TelevisionService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/channels")
    Flux<Channel> list(){
        return service.findAll();
    }

    @GetMapping("/api/v1/channels/{id}")
    Mono<Channel> getById(@PathVariable String id){
        return service.findById(id);
    }
}
