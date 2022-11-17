package com.dinhtv.LibraryManagement.controllers;


import com.dinhtv.LibraryManagement.models.dto.ReaderDTO;
import com.dinhtv.LibraryManagement.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping("/readers")
    public ResponseEntity<?> getAllReader() {
        List<ReaderDTO> readers = readerService.getAllReader();
        return ResponseEntity.ok(readers);
    }

    @GetMapping("/reader/{id}")
    public ResponseEntity<?> getReaderById(@PathVariable Integer id) {
        ReaderDTO readerDTO = readerService.getReaderById(id);
        return ResponseEntity.ok(readerDTO);
    }

    @PostMapping("/reader")
    public ResponseEntity<?> createReader(@RequestBody ReaderDTO readerDTO) {
        return ResponseEntity.ok(readerService.save(readerDTO));
    }

    @PutMapping("/reader/{id}")
    public ResponseEntity<?> updateReaderById(@PathVariable Integer id, @RequestBody ReaderDTO readerDTO) {
        return ResponseEntity.ok(readerService.updateReader(id, readerDTO));
    }

    @DeleteMapping("/reader/{id}")
    public void deleteReaderById(@PathVariable Integer id) {
        readerService.deleteReader(id);
    }
}
