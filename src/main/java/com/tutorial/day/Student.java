package com.tutorial.day;

import jakarta.persistence.*;

@Entity                    // "This class = a database table"
@Table(name = "students")  // "Name the table 'students'"
public class Student {

    @Id                                        // "This is the primary key"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // "Auto increment ID"
    private Integer id;

    // "This = a column"
    private String name;

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