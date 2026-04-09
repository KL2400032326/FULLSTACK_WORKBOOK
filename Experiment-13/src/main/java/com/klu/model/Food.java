package com.klu.model;

import jakarta.persistence.*;

@Entity
@Table(name = "food")
public class Food {

    @Id
    private int id;
    private String name;
    private double price;
    private String description;

    
    public Food() {
    }

   
    public Food(String name, float price, String description, int id) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.id=id;
    }
   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price2) {
        this.price = price2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
