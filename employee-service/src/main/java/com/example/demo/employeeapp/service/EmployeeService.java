package com.example.demo.employeeapp.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.employeeapp.config.AddressFeingClient;
import com.example.demo.employeeapp.dto.AddressResponse;
import com.example.demo.employeeapp.dto.EmployeeResponse;
import com.example.demo.employeeapp.entity.Employee;
import com.example.demo.employeeapp.repository.EmployeeRespository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@Service
public class EmployeeService {
   
	//using feing Client
	@Autowired
	private AddressFeingClient addressFeingClient;
	
	//using Discovery client for fetching hosts (instances) 
	//@Autowired
	//private DiscoveryClient discoveryClient;
	
	//for load balancer we can remive above oneadd belwo
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	//restTemplate
	@Autowired
	private RestTemplate restTemplate;
	
	//using WebClient
	@Autowired
	private WebClient webClient;
	
	@Autowired
	private EmployeeRespository employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	public EmployeeResponse getEmployeeDetails(int id) {
        
		Employee employee=employeeRepo.findById(id).get();
		
	EmployeeResponse employeeResponse=	modelMapper.map(employee, EmployeeResponse.class);
	
	AddressResponse addressResponse= addressFeingClient.getaddressByEmployeeId(id).getBody();
	
			employeeResponse.setAddressResponse( addressResponse);

	return employeeResponse;
	}
	
	//using Feing Client
	private AddressResponse callingUsingFeingClient(int id) {
     		ResponseEntity<AddressResponse> addressResponse =addressFeingClient.getaddressByEmployeeId(id);
                       
     		return addressResponse.getBody();
     
	
	}
	
	//Using web Client
    private AddressResponse callingUsingWebClient(int id) {
	                                        return webClient.get()
     			                            .uri("/address/"+id)
     			                            .retrieve()
     			                            .bodyToMono(AddressResponse.class)
     			                            .block();
  
     	
	}
	
	//Using restTemplate and discovery client for avoiding hard coding
	 private AddressResponse callingAddressResponseUsingRestTemplate(int id) {
		 //by using discovery client
    	// List<ServiceInstance> instances=discoveryClient.getInstances("address-service");
    	//ServiceInstance serviceInstance= instances.get(0);
    //	String Uri=serviceInstance.getUri().toString();
		 
		 //by using load balancer
		// ServiceInstance serviceInstance=loadBalancerClient.choose("address-service");
		// String Uri=serviceInstance.getUri().toString();
		// String contextroot=serviceInstance.getMetadata().get("configPath");
		
		//System.out.println(serviceInstance.getMetadata().get("configPath"));
		 
		 
    	// now we added loadbalancing to rest template
		 
    	 return restTemplate.getForObject("http://address-service/address-app/api/address/{id}", AddressResponse.class, id);
    	
	 }

	public List<EmployeeResponse> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		
	List<Employee> employeeList= employeeRepo.findAll();
//	     List<EmployeeResponse> response= new ArrayList<>();
//	  for (Employee employee : employeeList) {
//          EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
//          AddressResponse addressResponse = addressFeingClient.getaddressByEmployeeId(employee.getId()).getBody();
//          employeeResponse.setAddressResponse(addressResponse);
//          response.add(employeeResponse);
//      }
//	

	// but here we are hitting end point again and again so bettrt call al adress once and add
	List<EmployeeResponse> response= Arrays.asList(modelMapper.map(employeeList, EmployeeResponse[].class));
//	  
//	response.forEach(employee->{
//	
//			AddressResponse addressResponse=	addressFeingClient.getaddressByEmployeeId(employee.getId()).getBody()
//				; employee.setAddressResponse(addressResponse);
//	});
	
	
	
	List<AddressResponse> addressresponse=addressFeingClient.getAllAddresses().getBody();
	
	response.forEach(employee->{
		for(AddressResponse add:addressresponse) {
			if(add.getEmployee_id()==employee.getId())
				employee.setAddressResponse(add);
		}
	});
	
		return response;
	}

	public String addingEmployee(EmployeeResponse employeeRequest) {
		// TODO Auto-generated method stub
		Employee employee=modelMapper.map(employeeRequest, Employee.class);
		Employee e= employeeRepo.save(employee);
	employeeRequest.getAddressResponse().setEmployee_id(e.getId());
		String s=addressFeingClient.addingEmplpyeeAddress(employeeRequest.getAddressResponse()).getBody();
		return "Employee details Added and "+ s;
	}
	
	}
