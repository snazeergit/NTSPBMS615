package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BootSecurityApp07FormDBAsAuthProviderSpringDataJPAEnhancedApplication {

	@Bean
	public BCryptPasswordEncoder createPwdEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(BootSecurityApp07FormDBAsAuthProviderSpringDataJPAEnhancedApplication.class, args);
	}

}
