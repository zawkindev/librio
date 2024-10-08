package com.example.demo.Service;


import com.example.demo.Repository.BookEntity;
import com.example.demo.Repository.Status;
import com.example.demo.Repository.StudentBookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Service
public class StudentBookService {
    public List<StudentBookEntity> getStudentBookList() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Query query = session.createQuery("From StudentBookEntity *");
        List<StudentBookEntity> studentBookList = query.getResultList();

        session.close();
        factory.close();

        return studentBookList;
    }

    public StudentBookEntity take(StudentBookEntity studentBook) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        studentBook.setCreatedDate(LocalDate.now());
        studentBook.setStatus(Status.TAKEN);

        session.save(studentBook);

        transaction.commit();
        session.close();
        factory.close();

        return studentBook;
    }

    public StudentBookEntity returnBook(StudentBookEntity studentBook) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        studentBook.setCreatedDate(LocalDate.now());
        studentBook.setStatus(Status.RETURNED);

        session.save(studentBook);

        transaction.commit();
        session.close();
        factory.close();

        return studentBook;
    }

    public StudentBookEntity getStudentBookById(String id) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        StudentBookEntity studentBook = session.get(StudentBookEntity.class, id);

        transaction.commit();
        session.close();
        factory.close();

        return studentBook;
    }

    public List<StudentBookEntity> getStudentBookTakenByStudentId(String id) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Query query = session.createQuery("From StudentBookEntity * where student.id = {id}");
        query.setParameter("id", StudentBookEntity.class);
        List<StudentBookEntity> studentBookList = query.getResultList();

        session.close();
        factory.close();

        return studentBookList;
    }

    public List<StudentBookEntity> getStudentBookTakenByBookId(String id) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Query query = session.createQuery("From StudentBookEntity * where book.id = {id}");
        query.setParameter("id", StudentBookEntity.class);
        List<StudentBookEntity> studentBookList = query.getResultList();

        session.close();
        factory.close();

        return studentBookList;
    }
}
