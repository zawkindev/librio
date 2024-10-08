package com.example.demo.Controller;

import com.example.demo.Repository.StudentEntity;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student/")
    public ResponseEntity<Boolean> create(@RequestBody StudentEntity student) {
        return ResponseEntity.ok(studentService.create(student));
    }

    @GetMapping("/student/")
    public ResponseEntity<List<StudentEntity>> getStudents() {
        return ResponseEntity.ok(StudentService.getStudentsList());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentEntity> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(studentService.delete(id));
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") Integer id, @RequestBody StudentEntity student) {
        return ResponseEntity.ok(studentService.update(id, student));
    }
}
