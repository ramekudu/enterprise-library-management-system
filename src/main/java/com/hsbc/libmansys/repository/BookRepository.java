package com.hsbc.libmansys.repository;

import com.hsbc.libmansys.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
