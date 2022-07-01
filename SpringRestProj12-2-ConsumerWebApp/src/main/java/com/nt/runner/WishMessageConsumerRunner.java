package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WishMessageConsumerRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplate object
		RestTemplate template = new RestTemplate();
		//Prepare service/base url
		String serviceUrl = "http://localhost:2020/SpringRestProj12-1-ProviderApp/wish/api/message";
		//consume the service using xxxFOrEntity(-) method
		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class);
		//process response
		System.out.println("Response Body: " + response.getBody());
		System.out.println("Response Code: " + response.getStatusCode());
		System.out.println("Response Headers: " + response.getHeaders());
		System.out.println("-------------------------------------------------");
		//consume the service using xxxForObject(-) method
		String response1 = template.getForObject(serviceUrl, String.class);
		System.out.println("Response : " + response1);
	}

}

//Runners in Spring boot application executes only when we run the application as the "Spring Boot App" or the "Java Application".
//If run the application as "Run on Server" then Runners will not be executed so you will get output.