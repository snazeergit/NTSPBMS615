package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BootJMSProj02PubSubPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJMSProj02PubSubPublisherApplication.class, args);
	}

}
