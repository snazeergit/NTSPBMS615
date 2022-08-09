package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsProj16EurekaServerAPIGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj16EurekaServerAPIGatewayApplication.class, args);
	}

}