package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.employee;

public interface EmpRepo extends JpaRepository<employee, Integer>{

}
