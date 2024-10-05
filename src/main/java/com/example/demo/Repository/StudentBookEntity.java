package com.example.demo.Repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "student_book")
public class StudentBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;


    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;
}
