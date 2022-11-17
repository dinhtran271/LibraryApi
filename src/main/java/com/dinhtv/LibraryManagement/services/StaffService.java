package com.dinhtv.LibraryManagement.services;

import com.dinhtv.LibraryManagement.models.dto.StaffDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StaffService {

    List<StaffDTO> getAllStaff();

    StaffDTO getStaffById(Integer id);

    StaffDTO save(StaffDTO staffDTO);

    StaffDTO updateStaff(Integer id, StaffDTO staffDTO);

    void deleteStaff(Integer id);
}
