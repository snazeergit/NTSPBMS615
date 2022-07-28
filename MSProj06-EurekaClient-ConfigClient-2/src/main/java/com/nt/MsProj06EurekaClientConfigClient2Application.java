package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsProj06EurekaClientConfigClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(MsProj06EurekaClientConfigClient2Application.class, args);
	}

}
