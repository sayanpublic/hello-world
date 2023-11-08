package com.sayanpublic.helloworld.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayanpublic.helloworld.entity.EmployeeEntity;
import com.sayanpublic.helloworld.model.Employee;
import com.sayanpublic.helloworld.repository.EmployeeRepository;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee employee) {
		if(employee.getEmployeeId()==null || employee.getEmployeeId().isEmpty()) {
			employee.setEmployeeId(UUID.randomUUID().toString());
		}
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		employeeRepository.save(employeeEntity);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
		List<Employee> employees = employeeEntityList.stream()
				.map(employeeEntity -> {
					Employee employee = new Employee();
					BeanUtils.copyProperties(employeeEntity, employee);
					return employee;
				})
				.collect(Collectors.toList());
		return employees;
	}

	@Override
	public Employee getEmployeeById(String id) {
		EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeEntity, employee);
		return employee;
	}

	@Override
	public String deleteEmployeeById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
