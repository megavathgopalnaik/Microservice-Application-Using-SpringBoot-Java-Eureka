package com.example.demo.employeeapp.dto;

import java.util.Objects;

public class EmployeeResponse {
	
	
	private int id;
	
	private String name;
	
	private String email;
	
	private String bloodgroup;
    
	private AddressResponse addressResponse;
	
	public AddressResponse getAddressResponse() {
		return addressResponse;
	}

	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	@Override
	public String toString() {
		return "EmployeeResponse [id=" + id + ", name=" + name + ", email=" + email + ", bloodgroup=" + bloodgroup
				+ ", addressResponse=" + addressResponse + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressResponse, bloodgroup, email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeResponse other = (EmployeeResponse) obj;
		return Objects.equals(addressResponse, other.addressResponse) && Objects.equals(bloodgroup, other.bloodgroup)
				&& Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name);
	}


}
