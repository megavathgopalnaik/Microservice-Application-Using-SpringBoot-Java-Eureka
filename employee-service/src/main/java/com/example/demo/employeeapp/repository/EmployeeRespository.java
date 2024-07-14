package com.example.demo.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.employeeapp.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
