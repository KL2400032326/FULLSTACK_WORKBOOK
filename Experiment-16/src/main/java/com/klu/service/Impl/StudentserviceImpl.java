package com.klu.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Student;
import com.klu.repo.StudentRepo;
import com.klu.service.StudentService;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service  
public class StudentserviceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;  

    @Override
    public String getWelcomeMessage() {
        return "Welcome to Student Management API!";
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(int id, Student updatedStudent) {
        Student existing = studentRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedStudent.getName());
            existing.setCourse(updatedStudent.getCourse());
            return studentRepo.save(existing);
        }
        return null;
    }

    @Override
    public String deleteStudent(int id) {
        studentRepo.deleteById(id);
        return "Student deleted successfully!";
    }

    @Override
    public List<Student> searchStudent(String name, String course) {
        return studentRepo.findByNameIgnoreCaseAndCourseIgnoreCase(name, course);
    }

    // ✅ IMPLEMENTED METHOD
    @Override
    public List<Student> getStudentsByCourse(String course, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return studentRepo.findByNameIgnoreCaseAndCourseIgnoreCase(course, pageable).getContent();
    }
}