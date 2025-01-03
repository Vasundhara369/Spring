package com.example.demo.service.datafetcher;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Tasks;
import com.example.demo.service.GraphQLService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class deleteTaskFetcher implements DataFetcher<String> {
	Configuration con = new Configuration().configure().addAnnotatedClass(Tasks.class);
	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	SessionFactory sf = con.buildSessionFactory(sr);
	
	@Override
	public String get(DataFetchingEnvironment data)
	{
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Tasks task=new Tasks();
		task.setTaskId(Integer.parseInt(data.getArgument("id")));
		task.setTaskName(data.getArgument("name"));
		session.delete(task);
		tx.commit();
		session.close();
		return "deleted";
	}
}


