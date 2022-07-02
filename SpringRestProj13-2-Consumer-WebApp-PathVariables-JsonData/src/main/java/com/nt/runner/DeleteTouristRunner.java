package com.nt.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeleteTouristRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {

		String serviceUrl = "http://localhost:2020/SpringRestProj13-1-ProviderApp-PathVariables-JsonData/wish/api/delete/{id}";

		template.delete(serviceUrl, Map.of("id", 10));

		System.out.println("_____________Delete______________");
		System.out.println("Delete operation is completed");
		System.out.println("_________________________________");
	}

}
/*Runners in Spring boot application executes only when we run the application as the "Spring Boot App" or the "Java Application".
If run the application as "Run on Server" then Runners will not be executed so you will get output.

When you have multiple runners in the application then make sure all the runner are working correctly else you will encounter 405 error.
It usually happens when copy past the code and runners will have old provider application urls. So as soon as you copy the consumer application
make sure you change the provider url or service url in all the runner applications*/