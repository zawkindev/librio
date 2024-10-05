package com.example.demo.Service;

import com.example.demo.Model.BookModel;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class BookService {
    private List<BookModel> bookList = new LinkedList<>();

    public BookService() {
        BookModel book1 = new BookModel(UUID.randomUUID().toString(), "Tail of Naruto Uzumaki", "Jiraya the Gallant");
        BookModel book2 = new BookModel(UUID.randomUUID().toString(), "Tail of Jiraya the Gallant", "Jiraya the Gallant");
        bookList.add(book1);
        bookList.add(book2);
    }

    public List<BookModel> getBookList() {
        return bookList;
    }

    public BookModel getById(String id) {
        for (BookModel b : bookList) {
            if (Objects.equals(b.getId(), id)) {
                return b;
            }
        }
        return null;
    }

    public Boolean delete(String id) {
        return bookList.removeIf(bookModel -> bookModel.getId().equals(id));
    }

    public Boolean update(String id, BookModel book) {
        for (BookModel b : bookList) {
            if (Objects.equals(b.getId(), id)) {
                b.setName(book.getName());
                b.setAuthor(book.getAuthor());
                return true;
            }
        }
        return false;
    }
}
