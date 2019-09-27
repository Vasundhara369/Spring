package com.example.interfaces;

import org.hibernate.Session;

import com.example.dao.Todo;

public interface getTaskInterface {
	
	public Todo getTask(Session session,Integer id);
}
