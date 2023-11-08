package com.sayanpublic.helloworld.service;

import java.util.List;

import com.sayanpublic.helloworld.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(String id);

	String deleteEmployeeById(String id);
	
}
