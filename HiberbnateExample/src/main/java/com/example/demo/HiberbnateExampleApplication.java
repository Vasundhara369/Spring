package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HiberbnateExampleApplication {

	public static void main(String[] args) {
		Student st=new Student();
    	
    	Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry sr=new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	SessionFactory sf=con.buildSessionFactory(sr);
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        tx.commit();	
	}

}
