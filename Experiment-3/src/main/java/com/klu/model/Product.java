package com.klu.model;

import javax.persistence.*;


@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String des;
    private double price;
    private int quantity;

    // Mandatory no-arg constructor
    public Product() {}

    // Parameterized constructor (NO id)
    public Product(String name, double price, int quantity, String des) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.des = des;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getDes() { return des; }

    public double getPrice() { return price; }

    public int getQuantity() { return quantity; }
}
