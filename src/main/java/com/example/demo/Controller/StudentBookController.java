package com.example.demo.Controller;

import com.example.demo.Repository.StudentBookEntity;
import com.example.demo.Service.StudentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student_book")
public class StudentBookController {
    @Autowired
    private StudentBookService studentBookService;


    @PostMapping({"/student_book/", "/student_book"})
    public ResponseEntity<StudentBookEntity> take(@RequestBody StudentBookEntity studentBook) {
        return ResponseEntity.ok(studentBookService.take(studentBook));
    }


    @PutMapping({"/student_book/", "/student_book"})
    public ResponseEntity<StudentBookEntity> returnBook(@RequestBody StudentBookEntity studentBook) {
        return ResponseEntity.ok(studentBookService.returnBook(studentBook));
    }

    @GetMapping({"/student_book/", "/student_book"})
    public ResponseEntity<List<StudentBookEntity>> getStudentBookList() {
        return ResponseEntity.ok(studentBookService.getStudentBookList());
    }

    @GetMapping("/student_book/{id}")
    public ResponseEntity<StudentBookEntity> getStudentBookById(@PathVariable("id") String id) {
        return ResponseEntity.ok(studentBookService.getStudentBookById(id));
    }

    @GetMapping("/student_book/student/{studentId}")
    public ResponseEntity<List<StudentBookEntity>> getStudentBookTakenByStudentId(@PathVariable("studentId") String id) {
        return ResponseEntity.ok(studentBookService.getStudentBookTakenByStudentId(id));
    }

    @GetMapping("/student_book/book/{bookId}")
    public ResponseEntity<List<StudentBookEntity>> getStudentBookTakenByBookId(@PathVariable("bookId") String id) {
        return ResponseEntity.ok(studentBookService.getStudentBookTakenByBookId(id));
    }
}
