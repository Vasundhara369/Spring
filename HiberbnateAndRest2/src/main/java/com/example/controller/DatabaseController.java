package com.example.controller;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.dao.Todo;
import com.example.service.addTaskService;
import com.example.service.deleteTaskService;
import com.example.service.editTaskService;
import com.example.service.getTaskService;
import com.example.service.getTasksService;

@RestController
public class DatabaseController {
	
	Configuration con;
	ServiceRegistry sr;
	SessionFactory sf;
	Session session;
	Transaction tx;
	
	@Autowired
	private addTaskService addServ;
	@Autowired
	private editTaskService editServ;
	@Autowired
	private getTaskService getServ;
	@Autowired
	private deleteTaskService delServ;
	@Autowired
	private getTasksService getTasksServ;

	public DatabaseController() {
		con = new Configuration().configure().addAnnotatedClass(Todo.class);
		sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		sf = con.buildSessionFactory(sr);
		session = sf.openSession();
		tx = session.beginTransaction();
		tx.commit();
	}

	@CrossOrigin(origins = "http://172.17.0.3:3000")
	@PostMapping(path = "/addTask", consumes = "application/json")
	public Todo addTask(@RequestBody Todo task) {
		session = sf.openSession();
		tx = session.beginTransaction();
		Todo t = addServ.addTask(session, task);
		tx.commit();
		return t;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping(path = "/editTask", consumes = "application/json")
	public Todo editTask(@RequestBody Todo task) {
		session = sf.openSession();
		tx = session.beginTransaction();
		Todo t = editServ.editTask(session, task);
		tx.commit();
		return t;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getTask/{id}")
	public Todo getTask(@PathVariable(name = "id") Integer id) {
		session = sf.openSession();
		return getServ.getTask(session, id);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable(name = "id") Integer id) {
		session = sf.openSession();
		tx = session.beginTransaction();
		String s = delServ.deleteTask(session, id);
		tx.commit();
		return s;
	}

	@CrossOrigin(origins = "http://172.17.0.3:3000")
	@GetMapping("/getTasks")
	public List<Todo> getTasks() {
		session = sf.openSession();
		return getTasksServ.getTasks(session);
	}
}
