package com.example.demo.Service;

import com.example.demo.Exception.LyuboyException;
import com.example.demo.Repository.BookEntity;
import com.example.demo.Repository.StudentBookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class BookService {
    public Boolean create(BookEntity book) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        session.save(book);

        session.close();
        factory.close();

        return true;
    }

    public static List<BookEntity> getBookList() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Query query = session.createQuery("From BookEntity *");
        List<BookEntity> bookList = query.getResultList();

        for (BookEntity b : bookList) {
            validate(b);
        }

        session.close();
        factory.close();

        return bookList;
    }

    public BookEntity getById(Integer id) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        BookEntity book = session.get(BookEntity.class, id);

        validate(book);
        session.close();
        factory.close();

        return book;
    }

    public Boolean delete(Integer id) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Query query = session.createQuery("DELETE FROM Book WHERE id = :bookId");
        query.setParameter("bookId", id);
        int result = query.executeUpdate();

        session.close();
        factory.close();

        return result > 0;
    }

    public Boolean update(Integer id, BookEntity book) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        BookEntity oldBook = session.get(BookEntity.class, id);
        boolean updated = false;
        if (oldBook != null) {
            session.update(book);
            updated = true;
        }

        validate(book);

        session.close();
        factory.close();

        return updated;
    }


    public static void validate(BookEntity book) {
        if (book.getId() == null) {
            throw new LyuboyException("ID of student or book is NULL!");
        }
    }
}
