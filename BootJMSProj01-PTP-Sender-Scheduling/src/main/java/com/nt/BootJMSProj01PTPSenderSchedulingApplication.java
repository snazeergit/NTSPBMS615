package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootJMSProj01PTPSenderSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJMSProj01PTPSenderSchedulingApplication.class, args);
	}

}
