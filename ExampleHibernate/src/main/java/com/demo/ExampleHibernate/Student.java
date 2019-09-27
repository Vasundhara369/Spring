package com.demo.ExampleHibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {
@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", course=" + course + "]";
	}
@Id
private int sid;
private String sname;
@ManyToOne
private Course course;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
}
