package com.triplepack.cable;

import com.triplepack.cable.query.CableQueryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CableApplicationTests {

	@Autowired
	CableQueryRepository repository;

	@Test
	public void contextLoads() {
		repository.findAll().toStream().forEach(c -> System.out.println());
	}
}
