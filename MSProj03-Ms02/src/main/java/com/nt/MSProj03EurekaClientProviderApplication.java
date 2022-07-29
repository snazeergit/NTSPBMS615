package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MSProj03EurekaClientProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MSProj03EurekaClientProviderApplication.class, args);
	}

}
