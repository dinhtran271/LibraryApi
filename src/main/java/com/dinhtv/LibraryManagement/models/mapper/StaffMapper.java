package com.dinhtv.LibraryManagement.models.mapper;

import com.dinhtv.LibraryManagement.models.dto.StaffDTO;
import com.dinhtv.LibraryManagement.models.entity.Staff;
import org.springframework.stereotype.Component;

@Component
public class StaffMapper {

    public Staff toStaffEntity(StaffDTO staffDTO) {
        Staff staff = new Staff();
        staff.setName(staffDTO.getName());
        staff.setDateOfBirth(staffDTO.getDateOfBirth());
        staff.setPhone(staffDTO.getPhone());
        return staff;
    }

    public StaffDTO toStaffDto(Staff staff) {
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setId(staff.getId());
        staffDTO.setName(staff.getName());
        staffDTO.setDateOfBirth(staff.getDateOfBirth());
        staffDTO.setPhone(staff.getPhone());
        return staffDTO;
    }

    public Staff toStaffEntity(Staff staff, StaffDTO staffDTO) {
        staff.setName(staffDTO.getName());
        staff.setDateOfBirth(staffDTO.getDateOfBirth());
        staff.setPhone(staffDTO.getPhone());
        return staff;
    }
}
