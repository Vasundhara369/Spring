package com.example.interfaces;

import java.util.List;

import org.hibernate.Session;

import com.example.dao.Todo;

public interface getTasksInterface {
	
	public List<Todo> getTasks(Session session);
}
