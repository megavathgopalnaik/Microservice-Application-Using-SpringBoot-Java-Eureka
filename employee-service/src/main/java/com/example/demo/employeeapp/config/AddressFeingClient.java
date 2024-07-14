package com.example.demo.employeeapp.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.employeeapp.dto.AddressResponse;


//if we add @RibbonClient(name="address-service")and add address-service.ribbion.listofserver=http;8081,http;;8082 in properties 
//will work but it is not supported in new version of sprignboot.  

@FeignClient(name="ADDRESS-SERVICE",path = "/address-app/api")
public interface AddressFeingClient {
	
	@GetMapping("/address/{employeeid}")
	public ResponseEntity<AddressResponse> getaddressByEmployeeId(@PathVariable("employeeid")int id);
	
	@GetMapping("/address")
	public ResponseEntity< List<AddressResponse>> getAllAddresses();
	
	@PostMapping("/addaddress")
	public ResponseEntity<String> addingEmplpyeeAddress(@RequestBody AddressResponse addressRequest);
}
