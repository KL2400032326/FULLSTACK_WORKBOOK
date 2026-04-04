package com.klu.repository;


import com.klu.entity.Product;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    // Derived Queries
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // JPQL Queries

    // a. Sorting by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getAllSortedByPrice();

    // b. Products above a price
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findExpensiveProducts(@Param("price") double price);

    // c. Products by category
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> getByCategory(@Param("category") String category);
}