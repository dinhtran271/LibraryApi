package com.dinhtv.LibraryManagement.services;

import com.dinhtv.LibraryManagement.models.dto.PublisherDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PublisherService {

    List<PublisherDTO> getAllPublisher();

    PublisherDTO getPublisherById(Integer id);

    PublisherDTO save(PublisherDTO publisherDTO);
    PublisherDTO updatePublisher(Integer id, PublisherDTO publisherDTO);

    void deletePublisher(Integer id);

}
