package com.nt.runner;

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

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String jsonRequestBody = "{ \"tid\":123, \"tname\":\"nazeer\",\"startPlace\":\"Nellore\",\"destPlace\":\"Hyderabad\" }";
		HttpEntity<String> httpEntity = new HttpEntity<String>(jsonRequestBody, headers);
		String serviceUrl = "http://localhost:2020/SpringRestProj13-1-ProviderApp-PathVariables-JsonData/wish/api/register";

		//Using postForEntity()
		ResponseEntity<String> responseEntity = template.postForEntity(serviceUrl, httpEntity, String.class);
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
	}

}
