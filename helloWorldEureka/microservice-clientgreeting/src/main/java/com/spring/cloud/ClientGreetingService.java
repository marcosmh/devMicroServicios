package com.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientGreetingService {

	@Autowired
	protected RestTemplate restTemplante;
	
	protected String serviceUrl;
	
	
	public ClientGreetingService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl: "http://" +serviceUrl;
	}
	
	public Greeting greeting(String name) {
		Greeting greating = restTemplante.getForObject(serviceUrl + "/greeting/{name}",Greeting.class,name);
		return greating;
	}
	
}
