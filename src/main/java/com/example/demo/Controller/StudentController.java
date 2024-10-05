package com.example.demo.Controller;

import com.example.demo.Repository.StudentEntity;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @PostMapping("/student/")
    public Boolean create(@RequestBody StudentEntity student) {
        return true;
    }

    @GetMapping("/student/")
    public List<StudentEntity> getStudents() {
        return StudentService.getStudentsList();
    }

    @GetMapping("/student/{id}")
    public StudentEntity getById(@PathVariable("id") Integer id) {
        return studentService.getById(id);
    }

    @DeleteMapping("/student/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return studentService.delete(id);
    }

    @PutMapping("/student/{id}")
    public Boolean update(@PathVariable("id") Integer id, @RequestBody StudentEntity student) {
        return studentService.update(id, student);
    }
}
