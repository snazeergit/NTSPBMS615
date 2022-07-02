package com.nt.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//Runner class to test the Get method in Producer
@Component("wishMessage")
public class WishMessageConsumerGet {

	@Autowired
	private RestTemplate template;

	@Value("${service.wish.url}")
	private String serviceUrl;
	//(or)
	//private String serviceUrl = "http://localhost:2020/SpringRestProj13-1-ProviderApp-PathVariables-JsonData/wish/api/message/{id}/{name}";

	//Normal User defined method
	public void run()  {
		//consume the service using xxxFOrEntity(-) method
		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class,
				Map.of("name", "Nazeer", "id", 1234));
		System.out.println("_____________Get______________");
		//process response
		System.out.println("Consumer-getForEntity(): ");
		System.out.println("Response Body: " + response.getBody());
		System.out.println("Response Code: " + response.getStatusCode());
		System.out.println("Response Headers: " + response.getHeaders());

		String response1 = template.getForObject(serviceUrl, String.class, 1234, "Nazeer");
		System.out.println("Consumer-getForObject(): ");
		System.out.println("Response : " + response1);
		System.out.println("_________________________________");
	}

}

//Runners in Spring boot application executes only when we run the application as the "Spring Boot App" or the "Java Application".
//If run the application as "Run on Server" then Runners will not be executed so you will get output.