package com.klu.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
private int StudId;
private String StudName;
private String gender;
@Autowired
private Certification certification;

public Student() {
	this.StudId=24000;
	this.StudName="Ganaraj";
	this.gender="Male";
}
public void display() {
System.out.print("Here the details of Student : \n"
+"Student Id : "+StudId+
"\nStudent Name : "+StudName+
"\nGender : "+gender
+"\nHere the details of Certification : "+"\nCertification ID :"+certification.getCertid()+"\nCertification name : "+certification.getCertName()+"\nCertification Date : "+certification.getCertdate());
}

}
