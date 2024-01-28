package com.example.bikeshowroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bikeshowroom.model.Employee;
																				// This Employee and integer is model name and the ID data type check in model page.
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}
