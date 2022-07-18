package com.nt.runner;

import java.security.Policy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Politician;

@Component
public class GetModePoliticianRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Autowired
	private ObjectMapper objectMapper;

	private String providerURL1 = "http://localhost:2020/SpringRestProj15-1-Politician-ProviderApp/politician/api/get";
	private String providerURL2 = "http://localhost:2020/SpringRestProj15-1-Politician-ProviderApp/politician/api/getList";
	private String providerURL3 = "http://localhost:2020/SpringRestProj15-1-Politician-ProviderApp/politician/api/getMap";

	@Override
	public void run(String... args) throws Exception {
		ResponseEntity<String> responseEntity1 = template.exchange(providerURL1, HttpMethod.GET, null, String.class);
		System.out.println("______________GET__________________");
		System.out.println("Headers: " + responseEntity1.getHeaders());
		System.out.println("Body : " + responseEntity1.getBody());
		System.out.println("Status Code Value: " + responseEntity1.getStatusCodeValue());
		System.out.println("Status Code : " + responseEntity1.getStatusCode());
		System.out.println("Deserialization: JSON -->Object");
		Politician politician = objectMapper.readValue(responseEntity1.getBody(), Politician.class);
		System.out.println("Java object content: " + politician);

		System.out.println("___________________________________");

		ResponseEntity<String> responseEntity2 = template.exchange(providerURL2, HttpMethod.GET, null, String.class);
		System.out.println("______________GET_LIST_____________");
		System.out.println("Headers: " + responseEntity2.getHeaders());
		System.out.println("Body : " + responseEntity2.getBody());
		System.out.println("Status Code Value: " + responseEntity2.getStatusCodeValue());
		System.out.println("Status Code : " + responseEntity2.getStatusCode());
		System.out.println("Deserialization: JSON -->Object conversion");

		//Approach-1
		Politician[] politicians = objectMapper.readValue(responseEntity2.getBody(), Politician[].class);
		List<Politician> list = Arrays.asList(politicians);
		list.forEach(System.out::println);

		// OR

		//Approach-2
		System.out.println("Using TypeReference():: ");
		List<Politician> list2 = objectMapper.readValue(responseEntity2.getBody(),
				new TypeReference<List<Politician>>() {
				});
		list2.forEach(System.out::println);
		System.out.println("___________________________________");

		ResponseEntity<String> responseEntity3 = template.exchange(providerURL3, HttpMethod.GET, null, String.class);
		System.out.println("______________GET_Map______________");
		System.out.println("Headers: " + responseEntity3.getHeaders());
		System.out.println("Body : " + responseEntity3.getBody());
		System.out.println("Status Code Value: " + responseEntity3.getStatusCodeValue());
		System.out.println("Status Code : " + responseEntity3.getStatusCode());
		System.out.println("Deserialization: JSON -->Object conversion ");

		System.out.println("Using TypeReference():: ");
		Map<String, String> map2 = objectMapper.readValue(responseEntity3.getBody(),
				new TypeReference<Map<String, String>>() {
				});
		//System.out.println(map2);
		map2.forEach((k, v) -> System.out.println(k + " :  " + v));
		System.out.println("___________________________________");
	}

}
