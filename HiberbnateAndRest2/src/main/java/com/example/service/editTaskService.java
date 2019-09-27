package com.example.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.example.dao.Todo;
import com.example.interfaces.editTaskInterface;

@Service
public class editTaskService implements editTaskInterface {

	public Todo editTask(Session session, Todo task) {
		Query query = session.createQuery("from Todo where taskId=:i");
		query.setParameter("i", task.getTaskId());
		Todo todo = (Todo) query.uniqueResult();
		session.delete(todo);
		session.save(task);
		return task;

	}
}
