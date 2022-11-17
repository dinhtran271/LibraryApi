package com.dinhtv.LibraryManagement.services;

import com.dinhtv.LibraryManagement.exception.NotFoundException;
import com.dinhtv.LibraryManagement.models.dto.PublisherDTO;
import com.dinhtv.LibraryManagement.models.entity.Publisher;
import com.dinhtv.LibraryManagement.models.mapper.PublisherMapper;
import com.dinhtv.LibraryManagement.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService{

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PublisherMapper publisherMapper;

    @Override
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> publishers = publisherRepository.findAll();
        List<PublisherDTO> publisherDTOS = new ArrayList<>();
        for (Publisher publisher:publishers) {
            publisherDTOS.add(publisherMapper.toPublisherDto(publisher));
        }
        return publisherDTOS;
    }

    @Override
    public PublisherDTO getPublisherById(Integer id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);
        if (publisher.isEmpty()) {
            throw new NotFoundException("Publisher don't exist");
        }else {
            return publisherMapper.toPublisherDto(publisher.get());
        }
    }

    @Override
    public PublisherDTO save(PublisherDTO publisherDTO) {
        Publisher publisher = publisherMapper.toPublisherEntity(publisherDTO);
        publisher = publisherRepository.save(publisher);
        return publisherMapper.toPublisherDto(publisher);
    }

    @Override
    public PublisherDTO updatePublisher(Integer id, PublisherDTO publisherDTO) {
        if (publisherDTO != null) {
            Optional<Publisher> publisher = publisherRepository.findById(id);
            if (publisher.isEmpty()) {
                throw new NotFoundException("Publisher don't exist");
            }else {
                Publisher newPublisher = publisher.get();
                newPublisher = publisherMapper.toPublisherEntity(newPublisher, publisherDTO);
                newPublisher = publisherRepository.save(newPublisher);
                return publisherMapper.toPublisherDto(newPublisher);
            }
        }
        return null;
    }

    @Override
    public void deletePublisher(Integer id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);
        if (publisher.isEmpty()) {
            throw new NotFoundException("Publisher don't exist");
        }else {
            publisherRepository.deleteById(id);
        }
    }
}
