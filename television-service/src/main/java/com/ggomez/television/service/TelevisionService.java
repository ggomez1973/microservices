package com.ggomez.television.service;

import com.ggomez.television.model.Channel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TelevisionService {
    Mono<Channel> save(Channel channel);
    Flux<Channel> findAll();
    Mono<Channel> findById(String id);
}
