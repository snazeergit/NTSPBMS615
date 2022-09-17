package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MiniProject15MsIplPlayerServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProject15MsIplPlayerServiceConsumerApplication.class, args);
	}

}
