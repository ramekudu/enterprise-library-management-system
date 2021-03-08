package com.hsbc.libmansys.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {


    @Id
    @Column(name = "isbn", length = 50, nullable = false, unique = true)
    private String isbn;
    @Column(name = "title", length = 100, nullable = false)
    private String title;
    @Column(name = "author", length = 100, nullable = false)
    private String author;
    @Column(name = "publisher", length = 100, nullable = false)
    private String publisher;
    @Column(name = "description", length = 100, nullable = false)
    private String description;



    @Override
    public String toString() {
        return "Book{" + "isbn='" + isbn + '\'' + ", title='" + title + '\'' + '}';
    }
}
