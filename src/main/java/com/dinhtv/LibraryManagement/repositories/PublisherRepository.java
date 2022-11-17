package com.dinhtv.LibraryManagement.repositories;

import com.dinhtv.LibraryManagement.models.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
