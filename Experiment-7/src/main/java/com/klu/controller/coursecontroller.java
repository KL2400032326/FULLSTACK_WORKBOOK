package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.model.course;
import com.klu.service.courseService;

@RestController
@RequestMapping("/course")
public class coursecontroller {

    @Autowired
    private courseService cs;

    // CREATE
    @PostMapping("/add")
    public ResponseEntity<course> insertion(@RequestBody course c) {
        course saved = cs.insertion(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // READ ALL
    @GetMapping("/view")
    public ResponseEntity<List<course>> ViewAll() {
        return ResponseEntity.ok(cs.ViewAll());
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletion(@PathVariable int id) {
        cs.deletion(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    // SEARCH
    @GetMapping("/search/{name}")
    public ResponseEntity<List<course>> search(@PathVariable String name) {
        return ResponseEntity.ok(cs.search(name));
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updation(@PathVariable int id, @RequestBody course c) {
        course updated = cs.updation(id, c);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found");
        }
    }
}