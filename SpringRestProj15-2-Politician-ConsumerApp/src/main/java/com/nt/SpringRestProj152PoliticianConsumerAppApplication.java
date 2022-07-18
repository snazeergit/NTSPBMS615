package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringRestProj152PoliticianConsumerAppApplication {

	@Bean
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ObjectMapper createObjectMapper() {
		return new ObjectMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRestProj152PoliticianConsumerAppApplication.class, args);
	}

}
