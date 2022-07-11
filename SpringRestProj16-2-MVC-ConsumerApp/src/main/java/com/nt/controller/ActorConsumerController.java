package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
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
		 * Provider url : http://localhost:2020/SpringRestProj16-1-ProviderApp-Actor/actor/api/report
		 * Request Method/Mode : GET
		 * Path Variables : No
		 * Response Content Type : application/json(default)
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

	@GetMapping("/actor_add")
	public String showRegisterActorFromPage(@ModelAttribute("actor") Actor actor) {
		//return LVN
		return "register_actor";
	}

	/*@PostMapping("/actor_add")
	public String registerActor(@ModelAttribute("actor") Actor actor, Map<String,Object> map ) //Observe this line
			throws JsonProcessingException {
		//Convert model class object to json content using ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		String jsonContent = mapper.writeValueAsString(actor); //Serialization
		System.out.println("registerActor: " + jsonContent);
	
		
		 * Provider url : http://localhost:2020/SpringRestProj16-1-ProviderApp-Actor/actor/api/save
		 * Request Method/Mode : POST
		 * Path Variables : No
		 * Response Content Type : text/plain
		 * request headers : contentType: application/json(default)
		 * request body type : JSON Content
		 * 
		 
		
		//Reading the provider URL from Properties file
		String serviceUrl = env.getRequiredProperty("registerActor.serviceUrl");
	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(serviceUrl, headers);
	
		//invoke Provider RestController operation/method using exchange(..) of RestTemplate
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.POST, entity, String.class);
	
		//Get Provider operation result
		String msg=response.getBody();
		
		//Keep result in Model attribute(Shared memory)
		map.put("resultMsg", msg); //Observe this line
		
		//Observe below lines
		//return "forward:actor_report"; Post mode request can not be forwarded to Get mode request url(Gives Error)
		return "redirect:actor_report"; //We can not use model attributes in this method in the redirected requested related methods and pages.
	}*/

	@PostMapping("/actor_add")
	public String registerActor(@ModelAttribute("actor") Actor actor, RedirectAttributes attrs)
			throws JsonProcessingException {
		//Convert model class object to json content using ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		String jsonContent = mapper.writeValueAsString(actor); //Serialization
		System.out.println("registerActor: " + jsonContent);

		/*
		 * Provider url : http://localhost:2020/SpringRestProj16-1-ProviderApp-Actor/actor/api/save
		 * Request Method/Mode : POST
		 * Path Variables : No
		 * Response Content Type : text/plain
		 * request headers : contentType: application/json(default)
		 * request body type : JSON Content
		 * 
		 */

		//Reading the provider URL from Properties file
		String serviceUrl = env.getRequiredProperty("registerActor.serviceUrl");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonContent, headers);

		//invoke Provider RestController operation/method using exchange(..) of RestTemplate
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.POST, entity, String.class);

		//Get Provider operation result
		String msg = response.getBody();

		//Keep result in Model attribute(Shared memory)
		attrs.addFlashAttribute("resultMsg", msg);

		//return "forward:actor_report"; Post mode request can not be forwarded to Get mode request url(Gives Error)
		return "redirect:actor_report"; //We can use flash attributes in this method and in the redirected requested related methods and pages.
	}

}
