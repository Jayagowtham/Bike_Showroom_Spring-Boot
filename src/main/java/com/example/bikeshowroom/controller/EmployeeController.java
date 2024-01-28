package com.example.bikeshowroom.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bikeshowroom.model.Bike;
import com.example.bikeshowroom.model.Employee;
import com.example.bikeshowroom.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/index")
	public String homePage()
	{
		return "index";
	}
	
	@GetMapping("/EmployeePage/view")
	public String employeeViewPage(Model model)
	{
		model.addAttribute("allEmployees", employeeService.showAllEmployee());
		return "employee/view";
	}
	
	@GetMapping("/EmployeePage/add")
	public String employeeAddPage(Model model)
	{
		model.addAttribute("obj", new Employee());
		return "employee/add";
	}
	
	@PostMapping("/EmployeePage/add")
	public String addEmploye(@ModelAttribute ("obj") Employee employee)
	{
		Optional<Employee> opt= employeeService.searchEmployee(employee.getEmployee_id());
		if(opt.isEmpty())
		{
			employeeService.addNewEmployee(employee);
			return "redirect:/EmployeePage/view";   // view getmapping "" have to be given here
		}
		else
		{
			return "/EmployeePage/add?failed";
		}
	}
	
	@GetMapping("/EmployeePage/edit/{id}")
	public String employEditPage(@PathVariable("id") Integer mod, Model model)
	{
		model.addAttribute("obj", employeeService.searchEmployee(mod));
		return "employee/edit";
	}
	
	@PostMapping("EmployeePage/edit")
	public String editEmployee(@ModelAttribute("obj") Employee employee)           // the Bike bike is converting the variable into local once
	{
		employeeService.addNewEmployee(employee);
		return "redirect:/EmployeePage/view";                       // this statement will be same as in controller line 49 becoz only edit is going so new methods
	}
	
	@GetMapping("/EmployeePage/delete/{id}")                         // this name should be same with edit.html line 19 and line 39 as like to address and this line is simialr to getmapping edit line /
	public String deleteEmployee(@PathVariable("id") Integer model)
	{
		employeeService.deleteEmployee(model);
		return "redirect:/EmployeePage/view";
	}
	
	
}
