package com.klu.service1.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Food;
import com.klu.repo.Foodrepo;
import com.klu.service1.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private Foodrepo repo;

   
    @Override
    public Food addFood(Food f) {
        return repo.save(f);
    }

  
    @Override
    public Food updateFoodDetails(Food f) {
        return repo.save(f);
    }

  
    @Override
    public Food getFoodById(int id) {
        return repo.findById(id).orElse(null);
    }

    
    @Override
    public List<Food> getAllFood() {
        return repo.findAll();
    }

    
    @Override
    public String deleteFood(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Food Deleted Successfully";
        } else {
            return "Food Not Found";
        }
    }

   
    @Override
    public Food changePrice(int id, double price) {
        Food food = repo.findById(id).orElse(null);
        if (food != null) {
            food.setPrice(price);
            return repo.save(food);
        }
        return null;
    }


	
}
