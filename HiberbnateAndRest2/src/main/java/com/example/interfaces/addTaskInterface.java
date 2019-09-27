package com.example.interfaces;

import org.hibernate.Session;

import com.example.dao.Todo;

public interface addTaskInterface {
	
	public Todo addTask(Session session,Todo task);
}
