package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("wishMessage")
public class WishMessageConsumer {

	@Autowired
	private RestTemplate template;

	@Value("${service.url}") //from properties file
	private String serviceUrl;

	//Normal user defined method
	public void run() {
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
