package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRestProj134ConsumerStandaloneAppPathVariablesJsonDataApplication {
	
	@Bean(name = "template")
	public RestTemplate creteTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRestProj134ConsumerStandaloneAppPathVariablesJsonDataApplication.class, args);
	}

}