package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Student;
import com.klu.service.StudentService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    // CREATE
    @PostMapping("/student/add")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(
                service.createStudent(student),
                HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping("/student/getall")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    // READ BY ID
    @GetMapping("/student/getbyid/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    // READ BY COURSE
    @GetMapping("/student/course/{course}")
    public ResponseEntity<List<Student>> getByCourse(
            @PathVariable String course,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(
                service.getStudentsByCourse(course, page, size));
    }

    // UPDATE
    @PutMapping("/student/update/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        return ResponseEntity.ok(
                service.updateStudent(id, student));
    }

    // DELETE
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteStudent(id));
    }
}