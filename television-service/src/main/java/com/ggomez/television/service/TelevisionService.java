package com.ggomez.television.service;

import com.ggomez.television.dtos.ChannelDTO;
import com.ggomez.television.dtos.SignalTypeDTO;
import com.ggomez.television.model.Channel;
import com.ggomez.television.model.SignalType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TelevisionService {
    Mono<ChannelDTO> save(ChannelDTO channel);
    Flux<ChannelDTO> findAll();
    Mono<ChannelDTO> findById(String id);
    Mono<SignalTypeDTO> save(SignalTypeDTO signal);
}
