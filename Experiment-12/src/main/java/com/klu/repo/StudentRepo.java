package com.klu.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    // search by name + course
    List<Student> findByNameIgnoreCaseAndCourseIgnoreCase(String name, String course);

    // pagination by course
    Page<Student> findByCourseIgnoreCase(String course, Pageable pageable);
}