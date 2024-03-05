package com.security.demo.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.security.demo.model.Employee;

@RestController
@RequestMapping("/rest")
public class RestContrroller {
	 private final String URI_EMPLOYEE = "http://localhost:8080/employee";

	 @Autowired
	 private RestTemplate restTemplate;

	    @GetMapping("/employee")
	    public ResponseEntity getAllEmployee() {
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
	        return restTemplate.exchange(URI_EMPLOYEE, HttpMethod.GET, entity, Employee[].class);
	    }

	    @GetMapping("/employee/{id}")
	    public ResponseEntity getEmployeeById(@PathVariable final long id) {
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
	        return restTemplate.exchange(URI_EMPLOYEE+"/"+id, HttpMethod.GET, entity, Employee.class);
	    }

	     @PostMapping("/employee")
	    public ResponseEntity createEmployee(@RequestBody final Employee newEmployee) {
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        HttpEntity < Employee > entity = new HttpEntity < > (newEmployee, httpHeaders);
	        return restTemplate.exchange(URI_EMPLOYEE, HttpMethod.POST, entity, Employee.class);
	    }

	     @PutMapping("/employee/{id}")
	    public ResponseEntity updateEmployee(@PathVariable final long id, @RequestBody Employee newEmployee) {
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        HttpEntity < Employee > entity = new HttpEntity < > (newEmployee, httpHeaders);
	        return restTemplate.exchange(URI_EMPLOYEE +"/"+ id, HttpMethod.PUT, entity, Employee.class);
	    }

	    @DeleteMapping("/employee/{id}")
	    public ResponseEntity < Employee > delete(@PathVariable final long id) {
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        HttpEntity < Employee > entity = new HttpEntity < > (httpHeaders);
	        return restTemplate.exchange(URI_EMPLOYEE +"/" +id, HttpMethod.DELETE, entity, Employee.class);
	    }
}
