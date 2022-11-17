package com.dinhtv.LibraryManagement.services;

import com.dinhtv.LibraryManagement.models.dto.BookDTO;
import com.dinhtv.LibraryManagement.models.dto.ReaderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReaderService {


    List<ReaderDTO> getAllReader();
    ReaderDTO getReaderById(Integer id);
    ReaderDTO save(ReaderDTO readerDTO);
    ReaderDTO updateReader(Integer id, ReaderDTO readerDTO);
    void deleteReader(Integer id);

}
