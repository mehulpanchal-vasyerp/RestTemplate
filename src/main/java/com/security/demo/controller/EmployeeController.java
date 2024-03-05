package com.security.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.model.Employee;
import com.security.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllData();
	}

	@PostMapping("/employee")
	public Employee add(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return employee;
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {

		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	@PutMapping("/employee/{id}")
	private Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.getEmployeeById(id);
		updatedEmployee.setUsername(employee.getUsername());
		updatedEmployee.setData(employee.getData());
		employeeService.saveEmployee(updatedEmployee);
		return updatedEmployee;
	}

	@DeleteMapping("/employee/{id}")
	public Employee deleteEmployeeById(@PathVariable Long id) {
		Employee employee= employeeService.getEmployeeById(id);
		employeeService.deleteEmployeeById(id);
		return employee;
	}

}
