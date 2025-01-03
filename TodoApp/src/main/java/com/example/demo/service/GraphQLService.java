package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.service.datafetcher.addTaskDataFetcher;
import com.example.demo.service.datafetcher.allTasksDataFetcher;
import com.example.demo.service.datafetcher.deleteTaskFetcher;
import com.example.demo.service.datafetcher.editTaskFetcher;
import com.example.demo.service.datafetcher.getTaskFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {
	public GraphQLService()
	{	
	}
 @Value("classpath:todo.graphql")
	Resource resource;
    private GraphQL graphQL;
    @Autowired
    private allTasksDataFetcher allTasks;
    @Autowired
    private getTaskFetcher getTask;
    @Autowired
    private addTaskDataFetcher addTask;
    @Autowired
    private editTaskFetcher editTask;
    @Autowired
    private deleteTaskFetcher deleteTask;
    @PostConstruct
    public void loadSchema() throws IOException
    {
    	File file=resource.getFile();
    	TypeDefinitionRegistry type=new SchemaParser().parse(file);
    	RuntimeWiring run=buildRuntimeWiring();
    	GraphQLSchema schema=new SchemaGenerator().makeExecutableSchema(type, run);
    	graphQL=GraphQL.newGraphQL(schema).build();
    }
    private RuntimeWiring buildRuntimeWiring()
    {
    	return RuntimeWiring.newRuntimeWiring().type("Query",
    			typeWiring->typeWiring
    			.dataFetcher("allTasks", allTasks)
    			.dataFetcher("task", getTask)
    			.dataFetcher("addTask", addTask)
    			.dataFetcher("editTask", editTask)
    			.dataFetcher("deleteTask", deleteTask))
    			.build();
    }
    public GraphQL getGraphQL()
    {
    	return graphQL;
    }
}