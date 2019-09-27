package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.GraphQLService;

import graphql.ExecutionResult;

@RestController
public class TodoResourceController {
	@Autowired
	GraphQLService serv;
	
@CrossOrigin(origins = "http://localhost:3000")
@PostMapping
public ResponseEntity<Object> getAllTasks(@RequestBody String query)
{
	System.out.println(query);
	//query=query.substring(1,query.length()-2);
	//System.out.println(query);
	ExecutionResult ex=serv.getGraphQL().execute(query);
	return new ResponseEntity<>(ex,HttpStatus.OK);
}

}
