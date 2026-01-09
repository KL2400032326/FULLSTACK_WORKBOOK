package com.klu.student;

public class StudentDetails {
private int studentId;
private String name;
private String course;
private int year;
public StudentDetails(int studentId, String name) {
	this.studentId=studentId;
	this.name=name;
}
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
