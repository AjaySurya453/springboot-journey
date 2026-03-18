package com.tutorial.day;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired  // Spring injects the repository automatically
    private StudentRepository repository;

    // READ ALL — from real database now!
    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    // CREATE — saves to database!
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id,
                                 @RequestBody Student updated) {
        updated.setId(id);
        return repository.save(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        repository.deleteById(id);
        return "Student " + id + " deleted!";
    }
}