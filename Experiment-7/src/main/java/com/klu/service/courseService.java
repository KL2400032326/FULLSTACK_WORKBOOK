package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.course;
import com.klu.repo.courseRepo;

@Service
public class courseService {

    @Autowired
    private courseRepo cr;

    // CREATE
    public course insertion(course c) {
        return cr.save(c);
    }

    // READ ALL
    public List<course> ViewAll() {
        return cr.findAll();
    }

    // DELETE
    public void deletion(int id) {
        cr.deleteById(id);
    }

    // SEARCH
    public List<course> search(String name) {
        return cr.findByName(name);
    }

    // UPDATE
    public course updation(int id, course newData) {
        course existing = cr.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(newData.getName());
            existing.setDuration(newData.getDuration());
            existing.setPrice(newData.getPrice());
            return cr.save(existing);
        }
        return null;
    }
}