package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Employee;

@RestController
public class EmployeeController {
 @PostMapping
 public Employee employee(Employee emp)
 {
	 return emp;
 }
}
