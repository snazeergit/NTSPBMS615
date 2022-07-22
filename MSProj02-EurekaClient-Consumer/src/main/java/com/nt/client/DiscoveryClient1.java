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
public class DiscoveryClient1 {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public String getProviderInstance() {

		List<ServiceInstance> instances = discoveryClient.getInstances("MSProj02-EurekaClient-Provider");
		ServiceInstance serviceInstance = instances.get(0);
		URI uri = serviceInstance.getUri();
		String url =uri.toString()+"/api/get/appointment";
		ResponseEntity<String> responseEntity = template.exchange(url, HttpMethod.GET, null, String.class);
		String body = responseEntity.getBody();
		return body;
	}

}
