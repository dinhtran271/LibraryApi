package com.dinhtv.LibraryManagement.services;

import com.dinhtv.LibraryManagement.exception.NotFoundException;
import com.dinhtv.LibraryManagement.models.dto.StaffDTO;
import com.dinhtv.LibraryManagement.models.entity.Staff;
import com.dinhtv.LibraryManagement.models.mapper.StaffMapper;
import com.dinhtv.LibraryManagement.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<StaffDTO> getAllStaff() {
        List<Staff> staffs = staffRepository.findAll();
        List<StaffDTO> staffDTOS = new ArrayList<>();
        for (Staff staff:staffs) {
            staffDTOS.add(staffMapper.toStaffDto(staff));
        }
        return staffDTOS;
    }

    @Override
    public StaffDTO getStaffById(Integer id) {
        Optional<Staff> staff = staffRepository.findById(id);
        if (staff.isEmpty()) {
            throw new NotFoundException("Staff don't exist");
        }else {
            return staffMapper.toStaffDto(staff.get());
        }
    }

    @Override
    public StaffDTO save(StaffDTO staffDTO) {
        Staff staff = staffMapper.toStaffEntity(staffDTO);
        staff = staffRepository.save(staff);
        return staffMapper.toStaffDto(staff);
    }

    @Override
    public StaffDTO updateStaff(Integer id, StaffDTO staffDTO) {
        if (staffDTO != null) {
            Optional<Staff> staff = staffRepository.findById(id);
            if (staff.isEmpty()) {
                throw new NotFoundException("Staff don't exist");
            }else {
                Staff newStaff = staff.get();
                newStaff = staffMapper.toStaffEntity(newStaff, staffDTO);
                newStaff = staffRepository.save(newStaff);
                return staffMapper.toStaffDto(newStaff);
            }
        }
        return null;
    }

    @Override
    public void deleteStaff(Integer id) {
        Optional<Staff> staff = staffRepository.findById(id);
        if (staff.isEmpty()) {
            throw new NotFoundException("Staff don't exist");
        }else {
            staffRepository.deleteById(id);
        }
    }
}
