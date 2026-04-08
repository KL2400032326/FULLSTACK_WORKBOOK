package com.klu.controller;
import com.klu.exception.InvalidInputException;
import com.klu.exception.StudentNotFoundException;
import com.klu.entity.Student;
import com.klu.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    // /student/{id}
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        // Handle invalid input (non-numeric)
        Long studentId;
        try {
            studentId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid ID format. ID must be a number.");
        }

        // Fetch student or throw exception
        return repo.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with ID: " + studentId));
    }
}
