package com.dinhtv.LibraryManagement.services;

import com.dinhtv.LibraryManagement.models.dto.BookDTO;
import com.dinhtv.LibraryManagement.models.entity.Book;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBook();

    BookDTO getBookById(Integer id);
    BookDTO save(BookDTO bookDTO);

    BookDTO updateBook(Integer id, BookDTO bookDTO);
    void delete(Integer id);
}
