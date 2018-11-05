package com.ggomez.television.repositories;

import com.ggomez.television.model.Channel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ChannelRepository extends ReactiveMongoRepository<Channel, String> {
}
