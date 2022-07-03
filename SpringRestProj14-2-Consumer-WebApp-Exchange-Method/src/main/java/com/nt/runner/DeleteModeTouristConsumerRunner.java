package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeleteModeTouristConsumerRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {

		String serviceUrl = "http://localhost:2020/SpringRestProj14-1-ProviderApp-PathVariables-JsonData/tourist/api/delete/{id}";
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.DELETE, null, String.class, 10);

		System.out.println("_____________Delete______________");
		System.out.println("Body : " + response.getBody());
		System.out.println("Status Code Value : " + response.getStatusCodeValue());
		System.out.println("Headers : " + response.getHeaders());
		System.out.println("Status Code : " + response.getStatusCode());
		System.out.println("_________________________________");
	}

}
/*Runners in Spring boot application executes only when we run the application as the "Spring Boot App" or the "Java Application".
If run the application as "Run on Server" then Runners will not be executed so you will get output.

When you have multiple runners in the application then make sure all the runner are working correctly else you will encounter 405 error.
It usually happens when copy past the code and runners will have old provider application urls. So as soon as you copy the consumer application
make sure you change the provider url or service url in all the runner applications*/