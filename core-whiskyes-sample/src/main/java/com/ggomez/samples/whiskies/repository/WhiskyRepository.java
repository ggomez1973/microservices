package com.ggomez.samples.whiskies.repository;

import com.ggomez.samples.whiskies.domain.Whisky;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhiskyRepository extends CrudRepository<Whisky, Long> {
}
