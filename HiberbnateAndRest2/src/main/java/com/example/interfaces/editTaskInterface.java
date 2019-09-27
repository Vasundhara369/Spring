package com.example.interfaces;

import org.hibernate.Session;

import com.example.dao.Todo;

public interface editTaskInterface {
	
	public Todo editTask(Session session,Todo task);
}
