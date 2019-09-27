package com.example.demo.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class employee {
	
@Id
private Integer empId;
private String name;
private float salary;

public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "employee [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
}
}
