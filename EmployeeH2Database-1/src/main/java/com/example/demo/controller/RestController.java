package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.employee;
import com.example.demo.repository.EmpRepo;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
 EmpRepo empr;
 @PostMapping("/addEmployeeH2")
 public employee addEmployeeH2(@RequestBody employee emp)
 {
	 empr.save(emp);
	 return emp;
 }
 @GetMapping("/getEmployeeH2/{id}")
 public void getEmployeeH2(@PathVariable(name="id") Integer id)
 {
	 System.out.println(id);
	 employee e=empr.findById(id).orElse(null);
	 System.out.println(e);
 }
}
