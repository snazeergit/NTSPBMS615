package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsProj07EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj07EurekaServerApplication.class, args);
	}

}
