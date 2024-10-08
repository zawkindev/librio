package com.example.demo.Controller;

import com.example.demo.Repository.StudentBookEntity;
import com.example.demo.Service.StudentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student_book")
public class StudentBookController {
    @Autowired
    private StudentBookService studentBookService;


    @PostMapping({"/student_book/", "/student_book"})
    public StudentBookEntity take(@RequestBody StudentBookEntity studentBook) {
        return studentBookService.take(studentBook);
    }


    @PutMapping({"/student_book/", "/student_book"})
    public StudentBookEntity returnBook(@RequestBody StudentBookEntity studentBook) {
        return studentBookService.returnBook(studentBook);
    }

    @GetMapping({"/student_book/", "/student_book"})
    public List<StudentBookEntity> getStudentBookList() {
        return studentBookService.getStudentBookList();
    }

    @GetMapping("/student_book/{id}")
    public StudentBookEntity getStudentBookById(@PathVariable("id") String id) {
        return studentBookService.getStudentBookById(id);
    }

    @GetMapping("/student_book/student/{studentId}")
    public List<StudentBookEntity> getStudentBookTakenByStudentId(@PathVariable("studentId") String id) {
        return studentBookService.getStudentBookTakenByStudentId(id);
    }

    @GetMapping("/student_book/book/{bookId}")
    public List<StudentBookEntity> getStudentBookTakenByBookId(@PathVariable("bookId") String id) {
        return studentBookService.getStudentBookTakenByBookId(id);
    }
}
