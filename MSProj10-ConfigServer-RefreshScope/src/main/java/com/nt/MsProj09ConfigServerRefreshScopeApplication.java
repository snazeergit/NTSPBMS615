package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MsProj09ConfigServerRefreshScopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj09ConfigServerRefreshScopeApplication.class, args);
	}

}
