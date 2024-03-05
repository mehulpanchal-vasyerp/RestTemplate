package com.security.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.demo.model.Employee;
import com.security.demo.repository.EmployeeReposiotry;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeReposiotry employeeReposiotry;

	@Override
	public List<Employee> getAllData() {
		// TODO Auto-generated method stub
		List<Employee> Employee = employeeReposiotry.findAll();
		return Employee;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeReposiotry.findById(id).get();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeReposiotry.save(employee);
		return employee;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		employeeReposiotry.deleteById(id);

	}
}