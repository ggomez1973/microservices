package com.triplepack.cable.query;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;

@NoRepositoryBean
interface ReadOnlyReactiveRepository<T, ID extends Serializable> extends Repository<T, ID> {
   <S extends T> Flux<S> findAll();
}

public interface CableQueryRepository extends ReadOnlyReactiveRepository<Cable, String> {

}
