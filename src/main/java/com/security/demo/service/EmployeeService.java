package com.security.demo.service;

import java.util.List;
import java.util.Optional;

import com.security.demo.model.Employee;

public interface EmployeeService {
	List<Employee> getAllData();

	Employee getEmployeeById(Long id);
	Employee saveEmployee(Employee employee);
	void deleteEmployeeById(Long id);

}
