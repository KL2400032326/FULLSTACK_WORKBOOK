package com.klu.model;

import org.springframework.stereotype.Component;

@Component
public class Certification {
private int Certid;
private String Certname;
private String dateOfCompletion;
public Certification(){
	this.Certid=32326;
	this.Certname="PCAP";
	this.dateOfCompletion="11-01-2026";
}
public int getCertid() {
	return Certid;
}
public String  getCertName() {
	return Certname;
}
public String getCertdate() {
	return dateOfCompletion;
}


}
