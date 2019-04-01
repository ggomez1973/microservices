package com.ggomez.television.repositories;

import com.ggomez.television.model.SignalType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SignalTypeRepository extends ReactiveMongoRepository<SignalType, String> {
}
