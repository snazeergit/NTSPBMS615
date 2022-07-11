package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;

@Controller
public class ActorConsumerController {

	@Autowired
	private RestTemplate template;

	@Autowired
	private Environment env;

	@GetMapping("/")
	public String showHome() {
		//return LVN (Logical View Name)
		return "home";
	}

	@GetMapping("/actor_report")
	public String fetchAllActors(Map<String, Object> map) throws Exception {
		/*
		 * Provider url: http://localhost:2020/SpringRestProj16-1-ProviderApp-Actor/actor/api/report
		 * Request Method/Mode: GET
		 * Path Variables:No
		 * Response Content Type:application/json(default)
		 * 
		 */
		//Reading the provider URL from Properties file
		String serviceUrl = env.getRequiredProperty("fetchAllActors.serviceUrl");

		//invoke Provider RestController operation/method using exchange(..) of RestTemplate
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);

		//Get JSON response from response object
		String jsonBody = response.getBody();
		System.out.println("JSON response : " + jsonBody);

		//Convert JSON body in List<Actor> object
		ObjectMapper mapper = new ObjectMapper();
		List<Actor> list = mapper.readValue(jsonBody, new TypeReference<List<Actor>>() {
		});
		System.out.println("Java response : " + list);
		map.put("actorsInfo", list);
		//return LVN
		return "show_report";
	}
}
