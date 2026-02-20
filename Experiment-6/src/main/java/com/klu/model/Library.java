package com.klu.model;

public class Library {
private int id;
private double price;
private String title;
private String author;
public Library() {
	
}
public Library( int id , String title, String author,double price) {
	this.id=id;
	this.setPrice(price);
	this.settitle(title);
	this.setAuthor(author);
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String gettitle() {
	return title;
}
public void settitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
