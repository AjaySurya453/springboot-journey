package com.tutorial.day;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private List<Student> students =new ArrayList<>();

    public StudentController(){
        students.add(new Student(1,"Ajay","ajaysurya4532gmail.com"));
        students.add(new Student(2,"Ravi","ravi@gmail.com"));
    }
    @GetMapping
    public List<Student> getAllStudents(){return students;}

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){return students.get(id-1);}

    @PostMapping
    public String setStudent(@RequestBody Student student){
        students.add(student);
        return student.getName()+"sucessfully added";
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student updated){
        students.set(id-1, updated);
        return "Student"+id+"updated!";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        Student remove=students.remove(id -1);
        return remove.getName()+"removed sucessfully";
    }
}
