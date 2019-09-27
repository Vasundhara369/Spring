package com.example.service;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.example.dao.Todo;
import com.example.interfaces.addTaskInterface;

@Service
public class addTaskService implements addTaskInterface {

	public Todo addTask(Session session, Todo task) {
		session.save(task);
		return task;
	}

}
