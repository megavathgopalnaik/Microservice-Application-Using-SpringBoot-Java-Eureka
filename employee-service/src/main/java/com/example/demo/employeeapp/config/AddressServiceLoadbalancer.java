package com.example.demo.employeeapp.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;


//add for radmon load balancong,configuration = MyCustomConfiguration.class)
//if round robing only feign client interface will handel no need to loadbalancer class and config class


//@LoadBalancerClient(value ="ADDRESS-SERVICE")
public class AddressServiceLoadbalancer {
//	@LoadBalanced
//	@Bean
//	public Feign.Builder feignBuilder(){
//		
//		
//		 return Feign.builder();
//	}
//	

}
