package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Employee;

@RestController
public class EmployeeController {
	List<Employee> list=new ArrayList<Employee>();
 @PostMapping(path="/addEmployee",consumes="application/json")
 public Employee addEmployee(@RequestBody Employee emp)
 {
	 list.add(emp);
	 return emp;
 }
 @PostMapping("/deleteEmployee")
 public List deleteEmployee(@RequestBody Employee emp)
 {
	 int index=-1;
	 for(Employee e:list)
	 {
		 if(e.getEid()==emp.getEid())
			 index=list.indexOf(e);
	 }
	 list.remove(index);
	 return list;
 }
 @GetMapping("/AllEmployees")
 public List AllEmployees()
 {
	 return list;
 }
}