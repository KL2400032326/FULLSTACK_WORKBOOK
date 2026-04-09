package com.klu.service1;

import java.util.List;

import com.klu.model.Food;

public interface FoodService {

  public   Food addFood(Food f);

   public  Food updateFoodDetails(Food f);

   public  Food getFoodById(int id);

   public  List<Food> getAllFood();

   public String deleteFood(int id);

 public   Food changePrice(int id, double price);
}
