package com.example.demo.employeeapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeAppConfig {
	
	@Value("${addressservice.base.url}")
	private String baseUrl;
	@Bean
	 ModelMapper modelMapper() {
		return new ModelMapper();
	}
    
	@Bean
	WebClient webClient() {
		
		return WebClient
				.builder()
				.baseUrl(baseUrl)
				.build();
				
	}
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
