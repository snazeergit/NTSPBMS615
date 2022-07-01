package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.nt.runner.WishMessageConsumer;

@SpringBootApplication
public class SpringRestProj124ConsumerStandaloneAppWithNoRunnerApplication {

	@Bean(name = "template")
	public RestTemplate creteTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication
				.run(SpringRestProj124ConsumerStandaloneAppWithNoRunnerApplication.class, args);
		WishMessageConsumer consumer = context.getBean("wishMessage", WishMessageConsumer.class);
		consumer.run();
		((ConfigurableApplicationContext) context).close();
	}

}
