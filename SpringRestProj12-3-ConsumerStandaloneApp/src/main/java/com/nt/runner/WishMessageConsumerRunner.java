package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WishMessageConsumerRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Value("${service.url}") //from properties file
	private String serviceUrl;

	@Override
	public void run(String... args) throws Exception {
		//consume the service using xxxForEntity(-) method
		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class);

		//process response
		System.out.println("Consumer-getForEntity(): ");
		System.out.println("Response Body: " + response.getBody());
		System.out.println("Response Status code: " + response.getStatusCodeValue());
		System.out.println("Response Code: " + response.getStatusCode());
		System.out.println("Response Headers: " + response.getHeaders());
		System.out.println("-------------------------------------------------");
		//consume the service using xxxForObject(-) method
		String response1 = template.getForObject(serviceUrl, String.class);
		System.out.println("Consumer-getForObject(): ");
		System.out.println("Response : " + response1);
	}

}
/*Runners in Spring boot application executes only when we run the application as the "Spring Boot App" or the "Java Application".
If run the application as "Run on Server" then Runners will not be executed so you will get output.

When you have multiple runners in the application then make sure all the runner are working correctly else you will encounter 405 error.
It usually happens when copy past the code and runners will have old provider application urls. So as soon as you copy the consumer application
make sure you change the provider url or service url in all the runner applications*/