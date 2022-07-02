package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//Runner class to test the post method in Producer
@Component
public class TouristConsumerPostRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Value("${service.tourist.url}")
	private String serviceUrl;
	//or
	//	private String serviceUrl = "http://localhost:2020/SpringRestProj13-1-ProviderApp-PathVariables-JsonData/wish/api/register";

	@Override
	public void run(String... args) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		String xmlRequestBody = "<Tourist><tid>123</tid><tname>nazeer</tname><startPlace>nellore</startPlace><destPlace>hyderabad</destPlace></Tourist>";
		HttpEntity<String> httpEntity = new HttpEntity<String>(xmlRequestBody, headers);

		//Consuming the provider using postForEntity()
		ResponseEntity<String> responseEntity = template.postForEntity(serviceUrl, httpEntity, String.class);
		System.out.println("_____________Post______________");
		System.out.println("Consumer-postForEntity(): ");
		System.out.println("Body : " + responseEntity.getBody());
		System.out.println("Status Code Value : " + responseEntity.getStatusCodeValue());
		System.out.println("Headers : " + responseEntity.getHeaders());
		System.out.println("Status Code : " + responseEntity.getStatusCode());
		System.out.println("------------------------------");

		//Using postForObject()
		String response = template.postForObject(serviceUrl, httpEntity, String.class);
		System.out.println("Consumer-postForObject(): ");
		System.out.println("Response : " + response);
		System.out.println("_______________________________");
	}

}
/*Runners in Spring boot application executes only when we run the application as the "Spring Boot App" or the "Java Application".
If run the application as "Run on Server" then Runners will not be executed so you will get output.

When you have multiple runners in the application then make sure all the runner are working correctly else you will encounter 405 error.
It usually happens when copy past the code and runners will have old provider application urls. So as soon as you copy the consumer application
make sure you change the provider url or service url in all the runner applications*/