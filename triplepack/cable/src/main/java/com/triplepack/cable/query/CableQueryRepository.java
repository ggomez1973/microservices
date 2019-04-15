package com.triplepack.cable.query;

import com.triplepack.cable.domain.Cable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import reactor.core.publisher.Flux;

import java.io.Serializable;

@NoRepositoryBean
interface ReadOnlyReactiveRepository<T, ID extends Serializable> extends Repository<T, ID> {
   <S extends T> Flux<S> findAll();
}

public interface CableQueryRepository extends ReadOnlyReactiveRepository<Cable, String> {

}
