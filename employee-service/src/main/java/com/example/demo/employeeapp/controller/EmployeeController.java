package com.example.demo.employeeapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employeeapp.dto.EmployeeResponse;
import com.example.demo.employeeapp.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class EmployeeController {
	
	
	@Autowired
	private  EmployeeService employeeService;
	
	 private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	
	@GetMapping("/employees/{id}")
	 @CircuitBreaker(name = "employee-service", fallbackMethod = "erroMethoo")
	public ResponseEntity< EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id){
		
		
		EmployeeResponse employee= employeeService.getEmployeeDetails(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(employee);
		
	}
	
	
	
	
	    @GetMapping("/employees")
		public ResponseEntity<List< EmployeeResponse>> getAllEmployeeDetails(){
	    	
	    	
	    	System.out.println("Calling service");
		
		List<EmployeeResponse> response= employeeService.getAllEmployeeDetails();
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
		
	}
	    
	    @PostMapping("/addemployee")
	    public ResponseEntity<String> adddingEmployee(@RequestBody EmployeeResponse employeeRequest) {
	    	
	    	String result=employeeService.addingEmployee(employeeRequest);
	    	
	    	return ResponseEntity.status(HttpStatus.CREATED).body(result);
	    }
	    
	    
	    public  ResponseEntity< EmployeeResponse>  erroMethoo(Exception e) {
	    	logger.info("FallBack Method is called"+e.getMessage());
	    	EmployeeResponse response = new EmployeeResponse();
	    	return ResponseEntity.status(HttpStatus.OK).body(response);
	    	}


}
