package com.ggomez.television.controller;

import com.ggomez.television.dtos.ChannelDTO;
import com.ggomez.television.service.TelevisionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class ChannelController {
    private final TelevisionService service;

    public ChannelController(TelevisionService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/channels")
    Flux<ChannelDTO> list(){
        Flux<ChannelDTO> channels = service.findAll();
        channels.toStream().forEach(channel -> channel.add(
                linkTo(
                        methodOn(ChannelController.class).list()
                ).withSelfRel()));
        return channels;
    }

    @GetMapping("/api/v1/channels/{id}")
    Mono<ChannelDTO> getById(@PathVariable String id){
        Mono<ChannelDTO> c =  null;//service.findById(id).flatMap(i -> i.add(
//            linkTo(
//                    methodOn(ChannelController.class).getById(id)
//            ).withSelfRel()));
        return c;
    }
}
