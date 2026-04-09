package com.klu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.model.Food;
@Repository
public interface Foodrepo extends JpaRepository<Food, Integer> {
 List<Food> findByNameIgnoreCaseAndPrice(String name, float price);
}
