package com.dinhtv.LibraryManagement.models.mapper;

import com.dinhtv.LibraryManagement.models.dto.BookDTO;
import com.dinhtv.LibraryManagement.models.entity.Book;
import com.dinhtv.LibraryManagement.models.entity.Reader;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toBookEntity(BookDTO dto) {
        Book entity = new Book();
        entity.setName(dto.getName());
        entity.setAuthor(dto.getAuthor());
        entity.setCategory(dto.getCategory());
        entity.setYearOfPublication(dto.getYearOfPublication());
        entity.setPrice(dto.getPrice());
        return entity;
    }
    public BookDTO toBookDTO(Book entity) {
        BookDTO dto = new BookDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAuthor(entity.getAuthor());
        dto.setCategory(entity.getCategory());
        dto.setYearOfPublication(entity.getYearOfPublication());
        dto.setPrice(entity.getPrice());
        dto.setReaderId(entity.getReader().getId());
        dto.setPublisherId(entity.getPublisher().getId());
        dto.setStaffId(entity.getStaff().getId());
        return dto;
    }
    public Book toBookEntity(Book book, BookDTO bookDTO) {
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setCategory(bookDTO.getCategory());
        book.setYearOfPublication(bookDTO.getYearOfPublication());
        book.setPrice(bookDTO.getPrice());
        return book;
    }
}
