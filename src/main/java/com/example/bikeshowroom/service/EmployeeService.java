package com.example.bikeshowroom.service;

import java.util.List;
import java.util.Optional;

import com.example.bikeshowroom.model.Employee;

public interface EmployeeService {

	
	List<Employee> showAllEmployee();
	
	Optional<Employee> searchEmployee(Integer model);
	
	Employee addNewEmployee(Employee employee);
	
	void deleteEmployee(Integer mod);
}
