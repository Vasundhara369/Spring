package com.example.interfaces;

import org.hibernate.Session;

public interface deleteTaskInterface {
	
	public String deleteTask(Session session,Integer id);
}
