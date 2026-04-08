package com.klu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="Student")
public class Student {
@Id
private int Id;
private String name;
private String course;
public Student() {
	
}
public Student(int Id, String name, String course) {
	this.Id=Id;
	this.name=name;
	this.course=course;
}
public int getId() { 
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}

public void setName(String name) {
	this.name = name;
}
public String getName() {
	
	return name;
}

}
