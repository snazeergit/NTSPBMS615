package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsProj03Ms02Application {

	public static void main(String[] args) {
		SpringApplication.run(MsProj03Ms02Application.class, args);
	}

}
