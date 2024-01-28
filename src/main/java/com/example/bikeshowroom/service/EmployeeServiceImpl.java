package com.example.bikeshowroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bikeshowroom.model.Employee;
import com.example.bikeshowroom.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employRepo;

	@Override
	public List<Employee> showAllEmployee() {
		
		return employRepo.findAll();
	}

	@Override
	public Optional<Employee> searchEmployee(Integer model) {
		
		return employRepo.findById(model);
	}

	@Override
	public Employee addNewEmployee(Employee employee) {
		
		return employRepo.save(employee);
	}

	@Override
	public void deleteEmployee(Integer mod) {
		employRepo.deleteById(mod);
		
	}

}
