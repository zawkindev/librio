package com.example.demo.Controller;

import com.example.demo.Repository.BookEntity;
import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/book/")
    public ResponseEntity<Boolean> create(@RequestBody BookEntity book) {
        return ResponseEntity.ok(bookService.create(book));
    }

    @GetMapping("/book/")
    public ResponseEntity<List<BookEntity>> getBooks() {
        return ResponseEntity.ok(BookService.getBookList());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookEntity> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(bookService.delete(id));
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") Integer id, @RequestBody BookEntity book) {
        return ResponseEntity.ok(bookService.update(id, book));
    }
}
