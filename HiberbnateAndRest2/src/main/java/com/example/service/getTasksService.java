package com.example.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.example.dao.Todo;
import com.example.interfaces.getTasksInterface;

@Service
public class getTasksService implements getTasksInterface {

	public List<Todo> getTasks(Session session) {

		Query query = session.createQuery("from Todo");
		List<Todo> todo = query.list();
		return todo;
	}
}
