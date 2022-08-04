package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class MsProj12CircuiteBreakerHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj12CircuiteBreakerHystrixApplication.class, args);
	}

}
