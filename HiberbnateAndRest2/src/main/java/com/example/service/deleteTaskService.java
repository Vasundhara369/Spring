package com.example.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.example.dao.Todo;
import com.example.interfaces.deleteTaskInterface;

@Service
public class deleteTaskService implements deleteTaskInterface {

	public String deleteTask(Session session, Integer id) {

		Query query = session.createQuery("from Todo where taskId=:i");
		query.setParameter("i", id);
		Todo todo = (Todo) query.uniqueResult();
		session.delete(todo);
		return "deleted";
	}
}
