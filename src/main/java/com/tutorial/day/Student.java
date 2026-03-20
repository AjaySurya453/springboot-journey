package com.tutorial.day;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // "Auto increment ID"
    private Integer id;

    @NotBlank(message = "Name cannot not be empty")
    @Size(min = 1, max = 50, message = "Name don't exceed 50 characters")
    private String name;
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "please provide valid email")
    private String email;

    // Keep your existing constructors, getters, setters
    public Student() {}  // ← Add this empty constructor — JPA needs it!

    public Student(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}