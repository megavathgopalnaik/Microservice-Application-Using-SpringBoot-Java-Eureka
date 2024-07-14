package com.example.demo.addressapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.addressapp.dto.AddressResponse;
import com.example.demo.addressapp.service.AddressService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/address/{employeeid}")
	public ResponseEntity<AddressResponse> getaddressByEmployeeId(@PathVariable("employeeid")int id){
		System.out.println("Calling address service");
		AddressResponse response= addressService.getaddressByEmployeeId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	public ResponseEntity<AddressResponse> errorMethd(Exception e){
		
		AddressResponse response= new AddressResponse();
		
		return  ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	
	@GetMapping("/address")
	public ResponseEntity< List<AddressResponse>> getAllAddresses(){
		
		 List<AddressResponse> response= addressService.getAllAddresses();
				 
			
			return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping("/addaddress")
	public ResponseEntity<String> addingEmplpyeeAddress(@RequestBody AddressResponse addressRequest){
		
		String result= addressService.addingEmplpyeeAddress(addressRequest);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

}
