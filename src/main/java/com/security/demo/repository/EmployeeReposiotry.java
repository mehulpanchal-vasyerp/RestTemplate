package com.security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.demo.model.Employee;

public interface EmployeeReposiotry extends JpaRepository< Employee, Long> {

}
