package com.example.demo.employeeapp.dto;

import java.util.Objects;

public class AddressResponse {
	
	private int id;
	
	private String lane1;
	
	private String lane2;
	
	private String state;
	
	private int employee_id;
	
	
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	private String zip;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLane1() {
		return lane1;
	}

	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}

	public String getLane2() {
		return lane2;
	}

	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", lane1=" + lane1 + ", lane2=" + lane2 + ", state=" + state + ", zip=" + zip
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lane1, lane2, state, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressResponse other = (AddressResponse) obj;
		return id == other.id && Objects.equals(lane1, other.lane1) && Objects.equals(lane2, other.lane2)
				&& Objects.equals(state, other.state) && Objects.equals(zip, other.zip);
	}
}
