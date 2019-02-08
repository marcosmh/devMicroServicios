package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class MicroserviceClientGreetingApplication {
	
	public static final String SERVICE_URL = "http://GREETING-SERVICE";

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClientGreetingApplication.class, args);
	}
	
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ClientGreetingService helloWorldService() {
		return new ClientGreetingService(SERVICE_URL);
	}
	
	@Bean
	public ClientGreetingController homeWorldController() {
		return new ClientGreetingController(helloWorldService());
	}
	
	@Bean
	public ClientGreetingHomeController homeController() {
		return new ClientGreetingHomeController();
	}
	
	

}

