package com.tutorial.day;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Integer id){
        super("Student Not Found: "+ id);
    }
}
