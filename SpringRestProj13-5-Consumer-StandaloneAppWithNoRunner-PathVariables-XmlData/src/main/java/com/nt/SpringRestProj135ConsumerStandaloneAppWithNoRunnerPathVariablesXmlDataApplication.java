package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.nt.runner.TouristConsumerPost;
import com.nt.runner.WishMessageConsumerGet;

@SpringBootApplication
public class SpringRestProj135ConsumerStandaloneAppWithNoRunnerPathVariablesXmlDataApplication {

	@Bean(name = "template")
	public RestTemplate creteTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication
				.run(SpringRestProj135ConsumerStandaloneAppWithNoRunnerPathVariablesXmlDataApplication.class, args);
		//Get mapping consuming
		WishMessageConsumerGet consumerGet = context.getBean("wishMessage", WishMessageConsumerGet.class);
		consumerGet.run();
		//Post Mapping consuming
		TouristConsumerPost consumerPost = context.getBean("tourist", TouristConsumerPost.class);
		consumerPost.run();
		((ConfigurableApplicationContext) context).close();
	}

}
