package com.klu.StudentDetails;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.*;

@Component
public class Student {
@Value("32326")
private int studentId;
@Value("Ganaraj Patel")
private String name;
@Value("FSAD")
private String course;
@Value("2")
private int year;
public Student(int studentId, String name, int year, String course) {
	this.name=name;
	this.studentId=studentId;
	this.year=year;
	this.course=course;
}
public Student() {}


public void setCourse(String course) {
    this.course = course;
}

public void setYear(int year) {
    this.year = year;
}
public void display() {
	System.out.println("studentId:"+studentId);
	System.out.println("name:"+name);
	System.out.println("course:"+course);
	System.out.println("year:"+year);
	
}



}
