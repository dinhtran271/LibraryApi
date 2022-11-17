package com.dinhtv.LibraryManagement.repositories;

import com.dinhtv.LibraryManagement.models.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
