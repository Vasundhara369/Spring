package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.controller.DatabaseController;
@ComponentScan("com.example.controller")
@SpringBootApplication
public class HibernateAndRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAndRestApplication.class, args);
	}

}
