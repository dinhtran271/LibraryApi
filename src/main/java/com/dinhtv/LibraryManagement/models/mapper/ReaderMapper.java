package com.dinhtv.LibraryManagement.models.mapper;

import com.dinhtv.LibraryManagement.models.dto.ReaderDTO;
import com.dinhtv.LibraryManagement.models.entity.Reader;
import org.springframework.stereotype.Component;

@Component
public class ReaderMapper {

    public Reader toReaderEntity(ReaderDTO readerDTO) {
        Reader reader = new Reader();
        reader.setName(readerDTO.getName());
        reader.setAddress(readerDTO.getAddress());
        reader.setEmail(readerDTO.getEmail());
        reader.setPhone(readerDTO.getPhone());
        return reader;
    }
    public ReaderDTO toReaderDto(Reader reader) {
        ReaderDTO readerDTO = new ReaderDTO();
        readerDTO.setId(reader.getId());
        readerDTO.setName(reader.getName());
        readerDTO.setAddress(reader.getAddress());
        readerDTO.setEmail(reader.getEmail());
        readerDTO.setPhone(reader.getPhone());
        readerDTO.setStaffId(reader.getStaff().getId());
        return readerDTO;
    }
    public Reader toReaderEntity(Reader reader,ReaderDTO readerDTO) {
        reader.setName(readerDTO.getName());
        reader.setAddress(readerDTO.getAddress());
        reader.setEmail(readerDTO.getEmail());
        reader.setPhone(readerDTO.getPhone());
        return reader;
    }
}
