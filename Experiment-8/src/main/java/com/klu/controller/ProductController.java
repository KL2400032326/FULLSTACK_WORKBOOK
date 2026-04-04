package com.klu.controller;

import com.klu.entity.*;
import com.klu.repository.ProductRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepo repo;

    public ProductController(ProductRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

   
    @GetMapping("/filter")
    public List<Product> filterByPrice(@RequestParam double min,
                                       @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

   
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return repo.getAllSortedByPrice();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable double price) {
        return repo.findExpensiveProducts(price);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }
}