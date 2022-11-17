package com.dinhtv.LibraryManagement.models.mapper;

import com.dinhtv.LibraryManagement.models.dto.PublisherDTO;
import com.dinhtv.LibraryManagement.models.entity.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {
    public Publisher toPublisherEntity (PublisherDTO publisherDTO) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherDTO.getName());
        publisher.setAddress(publisherDTO.getAddress());
        publisher.setEmail(publisherDTO.getEmail());
        return publisher;
    }

    public PublisherDTO toPublisherDto (Publisher publisher) {
        PublisherDTO publisherDTO = new PublisherDTO();
        publisherDTO.setId(publisher.getId());
        publisherDTO.setName(publisher.getName());
        publisherDTO.setAddress(publisher.getAddress());
        publisherDTO.setEmail(publisher.getEmail());
        return publisherDTO;
    }

    public Publisher toPublisherEntity (Publisher publisher, PublisherDTO publisherDTO) {
        publisher.setName(publisherDTO.getName());
        publisher.setAddress(publisherDTO.getAddress());
        publisher.setEmail(publisherDTO.getEmail());
        return publisher;
    }
}
