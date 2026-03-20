package com.tutorial.day;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    public Student getStudentById(Integer id){
        return repository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
    }

    public Student updateStudent(Integer id, Student updated){
        updated.setId(id);
        return repository.save(updated);
    }

    public Student addStudent(Student student){
        return repository.save(student);
    }

    public String deleteStudent(Integer id){
        repository.deleteById(id);
        return "Sucessfully deleted: "+id;
    }
}
