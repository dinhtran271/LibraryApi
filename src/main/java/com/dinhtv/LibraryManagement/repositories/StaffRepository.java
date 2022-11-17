package com.dinhtv.LibraryManagement.repositories;

import com.dinhtv.LibraryManagement.models.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
