package com.example.demo.Service;


import com.example.demo.Repository.BookEntity;
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
public class StudentBookService {
    public static List<BookEntity> getStudentBookList() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Query query = session.createQuery("From BookEntity *");
        List<BookEntity> bookList = query.getResultList();

        session.close();
        factory.close();

        return bookList;
    }
}
