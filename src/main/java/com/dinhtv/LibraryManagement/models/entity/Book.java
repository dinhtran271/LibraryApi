package com.dinhtv.LibraryManagement.models.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;
    @Column(name = "book_name")
    private String name;
    @Column(name = "book_author")
    private String author;
    @Column(name = "book_category")
    private String category;
    @Column(name = "year_of_publication")
    private String yearOfPublication;
    @Column(name = "price")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "readerId")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "publisherId")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staff;
}
