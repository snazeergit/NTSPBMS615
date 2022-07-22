package com.nt.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerClient {

	@Autowired
	private DiscoveryClient client;
	@Autowired
	private RestTemplate template;

	public String billingInfo() {
		List<ServiceInstance> listInstances = client.getInstances("MS2");
		ServiceInstance serviceInstance = listInstances.get(0);
		URI uri = serviceInstance.getUri();
		String URL = uri.toString() + "/billing/api/getBill";
		ResponseEntity<String> response = template.exchange(URL, HttpMethod.GET, null, String.class);
		String body = response.getBody();
		return body;
	}
	
}
