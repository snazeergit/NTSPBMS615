package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//Runner class to test the Get method in Producer
@Component
public class GetTouristConsumerRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplate object
		RestTemplate template = new RestTemplate();
		//Prepare service/base url
		String serviceUrl = "http://localhost:2020/SpringRestProj13-1-Tourist-ProviderApp-PathVariables-JsonData/tourist/api/wish/{id}/{name}";
		//consume the service using xxxFOrEntity(-) method
		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class,
				Map.of("name", "Nazeer", "id", 1234));
		System.out.println("_____________Get______________");
		//process response
		System.out.println("Consumer-getForEntity(): ");
		System.out.println("Response Body: " + response.getBody());
		System.out.println("Response Code: " + response.getStatusCode());
		System.out.println("Response Headers: " + response.getHeaders());
		System.out.println("------------------------------");

		String response1 = template.getForObject(serviceUrl, String.class, 1234, "Nazeer");
		System.out.println("Consumer-getForObject(): ");
		System.out.println("Response : " + response1);
		System.out.println("_________________________________");
	}

}

/*Runners in Spring boot application executes only when we run the application as the "Spring Boot App" or the "Java Application".
If run the application as "Run on Server" then Runners will not be executed so you will get output.

When you have multiple runners in the application then make sure all the runner are working correctly else you will encounter 405 error.
It usually happens when copy past the code and runners will have old provider application urls. So as soon as you copy the consumer application
make sure you change the provider url or service url in all the runner applications*/