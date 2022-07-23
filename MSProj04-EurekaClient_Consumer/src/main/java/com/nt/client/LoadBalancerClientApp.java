package com.nt.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoadBalancerClientApp {

	@Autowired
	private RestTemplate template;

	@Autowired
	private LoadBalancerClient client;

	public String getProviderInstance() {
		ServiceInstance instance = client.choose("MSProj04-EurekaClient_Provider");
		URI uri = instance.getUri();
		String url = uri.toString() + "/billing/api/printBill";
		ResponseEntity<String> responseEntity = template.exchange(url, HttpMethod.GET, null, String.class);
		String response = responseEntity.getBody();
		return response;
	}

}
