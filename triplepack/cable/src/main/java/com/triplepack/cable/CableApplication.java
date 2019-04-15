package com.triplepack.cable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableDiscoveryClient  No hace falta desde Finchley release
public class CableApplication {
	public static void main(String[] args) {
		SpringApplication.run(CableApplication.class, args);
	}
}




