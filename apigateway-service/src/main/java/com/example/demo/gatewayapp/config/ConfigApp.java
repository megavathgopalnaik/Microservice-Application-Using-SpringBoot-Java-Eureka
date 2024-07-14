package com.example.demo.gatewayapp.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ConfigApp {
	
	
	
	  @Bean
	    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
	        return builder.routes()
	                .route("addressservice", r -> r.path("/address-app/api/**")
	                        .uri("lb://ADDRESS-SERVICE")
	                )

	                .route("employeeservice", r -> r.path("/employee-app/api/**")
	                        .uri("lb://EMPLOYEE-SERVICE")
	                )
	                .build();
	    
	}
	  

	    @Bean
	    public RestClient.Builder restClientBuilder() {
	        return RestClient.builder();
	    }

}
