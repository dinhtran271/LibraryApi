package com.dinhtv.LibraryManagement.controllers;

import com.dinhtv.LibraryManagement.models.dto.StaffDTO;
import com.dinhtv.LibraryManagement.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/staffs")
    public ResponseEntity<?> getAllStaffs() {
        List<StaffDTO> staffDTOS = staffService.getAllStaff();
        return ResponseEntity.ok(staffDTOS);
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<?> getStaffById(@PathVariable Integer id) {
        //StaffDTO staffDTO = staffService.getStaffById(id);
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    @PostMapping("/staff")
    public ResponseEntity<?> createStaff(@RequestBody StaffDTO staffDTO) {
        return ResponseEntity.ok(staffService.save(staffDTO));
    }

    @PutMapping("/staff/{id}")
    public ResponseEntity<?> updateStaffById(@PathVariable Integer id, @RequestBody StaffDTO staffDTO) {
        return ResponseEntity.ok(staffService.updateStaff(id, staffDTO));
    }

    @DeleteMapping("/staff/{id}")
    public void deleteStaffById(@PathVariable Integer id) {
        staffService.deleteStaff(id);
    }
}
