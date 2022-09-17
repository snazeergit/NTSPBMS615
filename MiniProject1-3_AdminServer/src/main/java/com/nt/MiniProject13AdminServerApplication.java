package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableAdminServer
@Slf4j
public class MiniProject13AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProject13AdminServerApplication.class, args);
	}

}
