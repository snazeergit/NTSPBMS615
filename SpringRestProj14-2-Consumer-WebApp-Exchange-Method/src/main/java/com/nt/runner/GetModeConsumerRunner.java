package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//Runner class to test the Get method in Producer
@Component
public class GetModeConsumerRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplate object
		RestTemplate template = new RestTemplate();
		//Prepare service/base url
		String serviceUrl1 = "http://localhost:2020/SpringRestProj14-1-ProviderApp-PathVariables-JsonData/wish/api/report";
		ResponseEntity<String> response1 = template.exchange(serviceUrl1, HttpMethod.GET, null, String.class);//no body +headers so 3rd param null
		System.out.println("_____________Get______________");
		System.out.println("Body : " + response1.getBody());
		System.out.println("Status Code Value : " + response1.getStatusCodeValue());
		System.out.println("Headers : " + response1.getHeaders());
		System.out.println("Status Code : " + response1.getStatusCode());
		System.out.println("________________________________");
		
		String serviceUrl2 = "http://localhost:2020/SpringRestProj14-1-ProviderApp-PathVariables-JsonData/wish/api/message/{id}/{name}";
		ResponseEntity<String> response = template.exchange(serviceUrl2, HttpMethod.GET, null, String.class,Map.of("id", 10, "name", "rajesh"));//no body + headers so 3rd param null
		System.out.println("_____________Get______________");
		System.out.println("Body : " + response.getBody());
		System.out.println("Status Code Value : " + response.getStatusCodeValue());
		System.out.println("Headers : " + response.getHeaders());
		System.out.println("Status Code : " + response.getStatusCode());
		System.out.println("________________________________");
	}

}
/*Runners in Spring boot application executes only when we run the application as the "Spring Boot App" or the "Java Application".
If run the application as "Run on Server" then Runners will not be executed so you will get output.

When you have multiple runners in the application then make sure all the runner are working correctly else you will encounter 405 error.
It usually happens when copy past the code and runners will have old provider application urls. So as soon as you copy the consumer application
make sure you change the provider url or service url in all the runner applications*/