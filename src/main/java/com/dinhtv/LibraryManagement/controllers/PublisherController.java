package com.dinhtv.LibraryManagement.controllers;

import com.dinhtv.LibraryManagement.models.dto.PublisherDTO;
import com.dinhtv.LibraryManagement.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public ResponseEntity<?> getAllPublishers() {
        List<PublisherDTO> publisherDTOS = publisherService.getAllPublisher();
        return ResponseEntity.ok(publisherDTOS);
    }

    @GetMapping("/publisher/{id}")
    public ResponseEntity<?> getPublisherByID(@PathVariable Integer id) {
        return ResponseEntity.ok(publisherService.getPublisherById(id));
    }

    @PostMapping("/publisher")
    public ResponseEntity<?> createPublisher(@RequestBody PublisherDTO publisherDTO) {
        return ResponseEntity.ok(publisherService.save(publisherDTO));
    }

    @PutMapping("/publisher/{id}")
    public ResponseEntity<?> updatePublisherById(@PathVariable Integer id, @RequestBody PublisherDTO publisherDTO) {
        return ResponseEntity.ok(publisherService.updatePublisher(id, publisherDTO));
    }

    @DeleteMapping("/publisher/{id}")
    public void deletePublisherById(@PathVariable Integer id) {
        publisherService.deletePublisher(id);
    }
}
