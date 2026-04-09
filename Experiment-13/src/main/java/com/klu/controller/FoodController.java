package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Food;
import com.klu.service1.FoodService;
@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService service;

   
    @PostMapping("/add")
    public Food addFood(@RequestBody Food f) {
        return service.addFood(f);
    }

    
    @GetMapping("/get/{id}")
    public Food getFoodById(@PathVariable int id) {
        return service.getFoodById(id);
    }

  
    @GetMapping("/all")
    public List<Food> getAllFood() {
        return service.getAllFood();
    }

    
    @PutMapping("/update")
    public Food updateFood(@RequestBody Food f) {
        return service.updateFoodDetails(f);
    }

    
    @DeleteMapping("/delete/{id}")
    public String deleteFood(@PathVariable int id) {
        return service.deleteFood(id);
    }

    
    @PutMapping("/changeprice/{id}/{price}")
    public Food changePrice(@PathVariable int id, @PathVariable double price) {
        return service.changePrice(id, price);
    }
}
