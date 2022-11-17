package com.dinhtv.LibraryManagement.controllers;

import com.dinhtv.LibraryManagement.models.dto.BookDTO;
import com.dinhtv.LibraryManagement.models.mapper.BookMapper;
import com.dinhtv.LibraryManagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        List<BookDTO> books = bookService.getAllBook();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {
        BookDTO bookDTO = bookService.getBookById(id);
        return ResponseEntity.ok(bookDTO);
    }

    @PostMapping("/book")
    public ResponseEntity<?> createBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.save(bookDTO));
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.updateBook(id, bookDTO));
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> DeleteBookById(@PathVariable Integer id) {
        bookService.delete(id);
        return null;
    }
}
