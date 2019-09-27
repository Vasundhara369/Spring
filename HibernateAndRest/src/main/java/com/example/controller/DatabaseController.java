package com.example.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.Actors;
import com.example.dao.Movies;


@RestController
public class DatabaseController {
	Configuration con;
	ServiceRegistry sr;
	SessionFactory sf;
	Session session;
	Transaction tx;
public DatabaseController() {
	// TODO Auto-generated constructor stub
    System.out.println("Controller");
	con=new Configuration().configure().addAnnotatedClass(Movies.class).addAnnotatedClass(Actors.class);
    sr=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	sf=con.buildSessionFactory(sr);
	session=sf.openSession();
    tx=session.beginTransaction();
	tx.commit();
}
@CrossOrigin(origins="http://localhost:3000")
@PostMapping(path="/addActor",consumes = "application/json")
public Actors addActors(@RequestBody Actors actor)
{
	session=sf.openSession();
    tx=session.beginTransaction();
	session.save(actor);
	tx.commit();
	return actor;
}

@PostMapping(path="/addMovie",consumes = "application/json")
public Movies addMovie(@RequestBody Movies movie)
{
	 session=sf.openSession();
	    tx=session.beginTransaction();
	session.save(movie);
	tx.commit();
	return movie;
}
@GetMapping("/getMovie/{id}")
public Movies getMovie(@PathVariable(name="id") int id)
{
	 session=sf.openSession();
	Query query=session.createQuery("from Movies where movieId=:i");
	query.setParameter("i", id);
	Movies movie=(Movies)query.uniqueResult();
	return movie;
	
}
@GetMapping("/getActor/{id}")
public Actors getActor(@PathVariable(name="id") int id)
{
	session=sf.openSession();
	Query query=session.createQuery("from Actors where actorId=:i");
	query.setParameter("i", id);
	Actors actor=(Actors)query.uniqueResult();
	return actor;
}
@DeleteMapping("/deleteActor/{id}")
public String deleteActor(@PathVariable(name="id") int id)
{
	session=sf.openSession();
	tx=session.beginTransaction();
	Query query=session.createQuery("from Actors where actorId=:i");
	query.setParameter("i", id);
	Actors actor=(Actors)query.uniqueResult();
	session.delete(actor);
	tx.commit();
	return "deleted";
}
@DeleteMapping("/deleteMovie/{id}")
public String deleteMovie(@PathVariable(name="id") int id)
{
	session=sf.openSession();
	tx=session.beginTransaction();
	Query query=session.createQuery("from Movies where movieId=:i");
	query.setParameter("i", id);
	Movies movie=(Movies)query.uniqueResult();
	session.delete(movie);
	tx.commit();
	return "deleted";
}
@CrossOrigin(origins="http://localhost:3000")
@GetMapping("/getActors")
public List<Actors> getActors()
{
	session=sf.openSession();
	Query query=session.createQuery("from Actors");
	List<Actors> actors=query.list();
	return actors;
}
@CrossOrigin(origins="http://localhost:3000")
@GetMapping("/getMovies")
public List<Movies> getMovies()
{
	session=sf.openSession();
	Query query=session.createQuery("from Movies");
	List<Movies> movies=query.list();
	return movies;
}
}
