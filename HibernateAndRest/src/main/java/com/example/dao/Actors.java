package com.example.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Actors {
@Id
private int actorId;
private String actorName;
@Override
public String toString() {
	return "Actors [actorId=" + actorId + ", actorName=" + actorName + "]";
}
public int getActorId() {
	return actorId;
}
public void setActorId(int actorId) {
	this.actorId = actorId;
}
public String getActorName() {
	return actorName;
}
public void setActorName(String actorName) {
	this.actorName = actorName;
}

}
