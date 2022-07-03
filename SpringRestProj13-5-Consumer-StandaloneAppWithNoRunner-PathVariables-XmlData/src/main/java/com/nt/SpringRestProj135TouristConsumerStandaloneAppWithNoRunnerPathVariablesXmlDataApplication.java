package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.nt.runner.PostTouristConsumer;
import com.nt.runner.GetTouristConsumer;

@SpringBootApplication
public class SpringRestProj135TouristConsumerStandaloneAppWithNoRunnerPathVariablesXmlDataApplication {

	@Bean(name = "template")
	public RestTemplate creteTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication
				.run(SpringRestProj135TouristConsumerStandaloneAppWithNoRunnerPathVariablesXmlDataApplication.class, args);
		//Get mapping consuming
		GetTouristConsumer consumerGet = context.getBean("wishMessage", GetTouristConsumer.class);
		consumerGet.run();
		//Post Mapping consuming
		PostTouristConsumer consumerPost = context.getBean("tourist", PostTouristConsumer.class);
		consumerPost.run();
		((ConfigurableApplicationContext) context).close();
	}

}
