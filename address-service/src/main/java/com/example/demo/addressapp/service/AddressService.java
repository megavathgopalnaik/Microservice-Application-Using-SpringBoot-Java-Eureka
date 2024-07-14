package com.example.demo.addressapp.service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.addressapp.dto.AddressResponse;
import com.example.demo.addressapp.entity.Address;
import com.example.demo.addressapp.repository.AddressRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class AddressService {
   
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AddressRepository addressRepo;
	
	public AddressResponse getaddressByEmployeeId(int id) {
		// TODO Auto-generated method stub
		
		Address address=addressRepo.finaddressByEmployeeId(id);
		
		AddressResponse response= modelMapper.map(address, AddressResponse.class);
		
		return response;
	}

	public List<AddressResponse> getAllAddresses() {
		// TODO Auto-generated method stub
	List<Address> addressList=	addressRepo.findAll();
	
	List<AddressResponse>addressResponse= Arrays.asList(modelMapper.map(addressList, AddressResponse[].class));
		
		return addressResponse;
	}

	public String addingEmplpyeeAddress(AddressResponse addressRequest) {
		// TODO Auto-generated method stub
		Address address= modelMapper.map(addressRequest, Address.class);
		addressRepo.save(address);
		
		return "Address Saved";
	}

}
