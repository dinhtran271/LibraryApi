package com.dinhtv.LibraryManagement.services;

import com.dinhtv.LibraryManagement.exception.NotFoundException;
import com.dinhtv.LibraryManagement.models.dto.BookDTO;
import com.dinhtv.LibraryManagement.models.entity.Book;
import com.dinhtv.LibraryManagement.models.entity.Publisher;
import com.dinhtv.LibraryManagement.models.entity.Reader;
import com.dinhtv.LibraryManagement.models.entity.Staff;
import com.dinhtv.LibraryManagement.models.mapper.BookMapper;
import com.dinhtv.LibraryManagement.repositories.BookRepository;
import com.dinhtv.LibraryManagement.repositories.PublisherRepository;
import com.dinhtv.LibraryManagement.repositories.ReaderRepository;
import com.dinhtv.LibraryManagement.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ReaderRepository readerRepository;
    @Autowired
    PublisherRepository publisherRepository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    BookMapper bookMapper;
    @Override
    public List<BookDTO> getAllBook() {
        List<Book> books= bookRepository.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            bookDTOS.add(bookMapper.toBookDTO(book));
        }
        return bookDTOS;
    }

    @Override
    public BookDTO getBookById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new NotFoundException("Book don't exist");
        }else {
            return bookMapper.toBookDTO(book.get());
        }
    }

    @Override
    public BookDTO save(BookDTO bookDTO) {
        Optional<Reader> reader = readerRepository.findById(bookDTO.getReaderId());
        Optional<Publisher> publisher = publisherRepository.findById(bookDTO.getPublisherId());
        Optional<Staff> staff = staffRepository.findById(bookDTO.getStaffId());
        Book book = bookMapper.toBookEntity(bookDTO);
        if (reader.isPresent()) {
            book.setReader(reader.get());
        }
        if (publisher.isPresent()) {
            book.setPublisher(publisher.get());
        }
        if (staff.isPresent()) {
            book.setStaff(staff.get());
        }
        book = bookRepository.save(book);
        return bookMapper.toBookDTO(book);
    }

    @Override
    public BookDTO updateBook(Integer id, BookDTO bookDTO) {
        if (bookDTO != null) {
            Optional<Book> newBook = bookRepository.findById(id);
            if (newBook.isEmpty()) {
                throw new NotFoundException("Book don't exist");
            }else {
                Book book = newBook.get();
                book = bookMapper.toBookEntity(book, bookDTO);
                Optional<Reader> reader = readerRepository.findById(bookDTO.getReaderId());
                Optional<Publisher> publisher = publisherRepository.findById(bookDTO.getPublisherId());
                Optional<Staff> staff = staffRepository.findById(bookDTO.getStaffId());
                if (reader.isPresent()) {
                    book.setReader(reader.get());
                }
                if (publisher.isPresent()) {
                    book.setPublisher(publisher.get());
                }
                if (staff.isPresent()) {
                    book.setStaff(staff.get());
                }
                book = bookRepository.save(book);
                return bookMapper.toBookDTO(book);
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()) {
            throw  new NotFoundException("Reader don't exist");
        }else {
            readerRepository.deleteById(id);
        }
    }
}
