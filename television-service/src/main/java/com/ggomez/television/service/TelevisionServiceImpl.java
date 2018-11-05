package com.ggomez.television.service;

import com.ggomez.television.model.Channel;
import com.ggomez.television.repositories.ChannelRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TelevisionServiceImpl implements TelevisionService {
    private final ChannelRepository channelRepo;

    public TelevisionServiceImpl(ChannelRepository channelRepo) {
        this.channelRepo = channelRepo;
    }

    public Mono<Channel> save(Channel channel){
        return channelRepo.save(channel);
    }

    @Override
    public Flux<Channel> findAll() {
        return channelRepo.findAll();
    }

    @Override
    public Mono<Channel> findById(String id) {
        return channelRepo.findById(id);
    }

}
