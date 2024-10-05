package com.example.demo.Controller;

import com.example.demo.Model.BookModel;
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
    public Boolean create(@RequestBody BookModel book) {
        return true;
    }

    @GetMapping("/book/")
    public List<BookModel> getBooks() {
        return bookService.getBookList();
    }

    @GetMapping("/book/{id}")
    public BookModel getById(@PathVariable("id") String id) {
        return bookService.getById(id);
    }

    @DeleteMapping("/book/{id}")
    public Boolean delete(@PathVariable("id") String id) {
        return bookService.delete(id);
    }

    @PutMapping("/book/{id}")
    public Boolean update(@PathVariable("id") String id, @RequestBody BookModel book) {
        return bookService.update(id, book);
    }


}
