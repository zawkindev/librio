package com.example.demo.Service;

import com.example.demo.Exception.LyuboyException;
import com.example.demo.Repository.BookEntity;
import com.example.demo.Repository.StudentEntity;
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
public class StudentService {
    public Boolean create(StudentEntity student) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        session.save(student);

        session.close();
        factory.close();

        return true;
    }

    public static List<StudentEntity> getStudentsList() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Query query = session.createQuery("From StudentEntity *");
        List<StudentEntity> studentList = query.getResultList();

        session.close();
        factory.close();

        return studentList;
    }

    public StudentEntity getById(Integer id) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        StudentEntity student = session.get(StudentEntity.class, id);

        session.close();
        factory.close();

        return student;
    }

    public Boolean delete(Integer id) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Query query = session.createQuery("DELETE FROM Student WHERE id = :studentId");
        query.setParameter("studentId", id);
        int result = query.executeUpdate();

        session.close();
        factory.close();

        return result > 0;
    }

    public Boolean update(Integer id, StudentEntity student) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        StudentEntity oldStudent = session.get(StudentEntity.class, id);
        boolean updated = false;
        if (oldStudent != null) {
            session.update(student);
            updated = true;
        }

        session.close();
        factory.close();

        return updated;
    }
}
