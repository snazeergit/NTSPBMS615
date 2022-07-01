package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//Runner class to test the Get method in Producer
@Component
public class WishMessageConsumerGetRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplate object
		RestTemplate template = new RestTemplate();
		//Prepare service/base url
		String serviceUrl = "http://localhost:2020/SpringRestProj13-1-ProviderApp-PathVariables-JsonData/wish/api/message/{id}/{name}";
		//consume the service using xxxFOrEntity(-) method
		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class,
				Map.of("name", "Nazeer", "id", 1234));
		//process response
		System.out.println("Consumer-getForEntity(): ");
		System.out.println("Response Body: " + response.getBody());
		System.out.println("Response Code: " + response.getStatusCode());
		System.out.println("Response Headers: " + response.getHeaders());

		String response1 = template.getForObject(serviceUrl, String.class, 1234, "Nazeer");
		System.out.println("Consumer-getForObject(): ");
		System.out.println("Response : " + response1);
	}

}

//Runners in Spring boot application executes only when we run the application as the "Spring Boot App" or the "Java Application".
//If run the application as "Run on Server" then Runners will not be executed so you will get output.