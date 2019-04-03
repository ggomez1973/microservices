package com.triplepack.cable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker
public class CableApplication {
	public static void main(String[] args) {
		SpringApplication.run(CableApplication.class, args);
	}
}


