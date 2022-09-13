package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaProj03BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProj03BootApplication.class, args);
	}

}
