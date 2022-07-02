package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//Runner class to test the post method in Producer
@Component("tourist")
public class TouristConsumerPost {

	@Autowired
	private RestTemplate template;

	@Value("${service.tourist.url}")
	private String serviceUrl;
	//or
	//	private String serviceUrl = "http://localhost:2020/SpringRestProj13-1-ProviderApp-PathVariables-JsonData/wish/api/register";

	//Normal user defined method
	public void run() {
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
