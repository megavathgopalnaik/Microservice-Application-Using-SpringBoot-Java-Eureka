package com.example.demo.addressapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.addressapp.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
//@Query(nativeQuery = true,value="SELECT ea.id,ea.lane1,ea.lane2,ea.state,ea.zip FROM microservice.address ea join microservice.employee e on e.id=ea.employee_id where ea.employee_id=:employeeId;") 

	@Query(nativeQuery = true,value="SELECT * FROM address ea where ea.employee_id=:employeeId;") 
	Address	finaddressByEmployeeId(@Param("employeeId")int id);

}
