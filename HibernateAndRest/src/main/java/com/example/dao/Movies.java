package com.example.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Movies {
	@Id
  private int movieId;
  public String getMovieName() {
		return movieName;
	}
private String movieName;
  @ManyToOne
  private Actors leadActor;
  @ManyToOne
  private Actors leadActress;
public Actors getLeadActor() {
	return leadActor;
}
public void setMovieName(String movieName) {
	this.movieName = movieName;
}
public void setLeadActor(Actors leadActor) {
	this.leadActor = leadActor;
}
public Actors getLeadActress() {
	return leadActress;
}
public void setLeadActress(Actors leadActress) {
	this.leadActress = leadActress;
}
public int getMovieId() {
	return movieId;
}
public void setMovieId(int movieId) {
	this.movieId = movieId;
}

   
}
