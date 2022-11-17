package com.dinhtv.LibraryManagement.services;

import com.dinhtv.LibraryManagement.exception.NotFoundException;
import com.dinhtv.LibraryManagement.models.dto.BookDTO;
import com.dinhtv.LibraryManagement.models.dto.ReaderDTO;
import com.dinhtv.LibraryManagement.models.entity.Book;
import com.dinhtv.LibraryManagement.models.entity.Reader;
import com.dinhtv.LibraryManagement.models.entity.Staff;
import com.dinhtv.LibraryManagement.models.mapper.ReaderMapper;
import com.dinhtv.LibraryManagement.repositories.ReaderRepository;
import com.dinhtv.LibraryManagement.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReaderServiceImpl implements ReaderService{

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    ReaderMapper readerMapper;
    @Override
    public List<ReaderDTO> getAllReader() {
        List<Reader> readers = readerRepository.findAll();
        List<ReaderDTO> readerDTOS = new ArrayList<>();
        for (Reader reader:readers) {
            readerDTOS.add(readerMapper.toReaderDto(reader));
        }
        return readerDTOS;
    }

    @Override
    public ReaderDTO getReaderById(Integer id) {
        Optional<Reader> book = readerRepository.findById(id);
        if (book.isEmpty()) {
            throw  new NotFoundException("Reader don't exist");
        }else {
            return readerMapper.toReaderDto(book.get());
        }
    }

    @Override
    public ReaderDTO save(ReaderDTO readerDTO) {
        Optional<Staff> staff = staffRepository.findById(readerDTO.getStaffId());
        Reader reader = readerMapper.toReaderEntity(readerDTO);
        if (staff.isPresent()) {
            reader.setStaff(staff.get());
        }
        reader = readerRepository.save(reader);
        return readerMapper.toReaderDto(reader);
    }

    @Override
    public ReaderDTO updateReader(Integer id, ReaderDTO readerDTO) {
        if (readerDTO != null) {
            Optional<Reader> reader = readerRepository.findById(id);
            if (reader.isEmpty()) {
                throw  new NotFoundException("Reader don't exist");
            }else {
                Reader newReader = reader.get();
                newReader = readerMapper.toReaderEntity(reader.get(), readerDTO);
                Optional<Staff> staff = staffRepository.findById(readerDTO.getStaffId());
                if (staff.isPresent()) {
                    newReader.setStaff(staff.get());
                }
                newReader = readerRepository.save(newReader);
                return readerMapper.toReaderDto(newReader);
            }
        }
        return null;
    }

    @Override
    public void deleteReader(Integer id) {
        Optional<Reader> reader = readerRepository.findById(id);
        if(reader.isEmpty()) {
            throw  new NotFoundException("Reader don't exist");
        }else {
            readerRepository.deleteById(id);
        }
    }
}
