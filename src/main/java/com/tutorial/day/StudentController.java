package com.tutorial.day;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired  // Spring injects the repository automatically
    private StudentService service;

    // READ ALL — from real database now!
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // CREATE — saves to database!
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return service.addStudent(student);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id,
                                 @Valid @RequestBody Student updated) {
        return service.updateStudent(id, updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}