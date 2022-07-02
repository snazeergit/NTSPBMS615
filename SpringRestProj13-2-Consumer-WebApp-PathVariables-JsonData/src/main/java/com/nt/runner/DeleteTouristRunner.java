package com.nt.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeleteTouristRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {

		String serviceUrl = "http://localhost:2020/SpringRestProj13-1-ProviderApp-PathVariables-JsonData/wish/api/delete/{id}";

		template.delete(serviceUrl, Map.of("id", 10));

		System.out.println("_____________Delete______________");
		System.out.println("Delete operation is completed");
		System.out.println("_________________________________");
	}

}
