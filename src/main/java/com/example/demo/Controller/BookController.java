package com.example.demo.Controller;

import com.example.demo.Repository.BookEntity;
import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/book/")
    public Boolean create(@RequestBody BookEntity book) {
        return true;
    }

    @GetMapping("/book/")
    public List<BookEntity> getBooks() {
        return BookService.getBookList();
    }

    @GetMapping("/book/{id}")
    public BookEntity getById(@PathVariable("id") Integer id) {
        return bookService.getById(id);
    }

    @DeleteMapping("/book/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return bookService.delete(id);
    }

    @PutMapping("/book/{id}")
    public Boolean update(@PathVariable("id") Integer id, @RequestBody BookEntity book) {
        return bookService.update(id, book);
    }
}
