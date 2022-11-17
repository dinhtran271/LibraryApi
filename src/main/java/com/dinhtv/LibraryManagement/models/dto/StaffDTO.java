package com.dinhtv.LibraryManagement.models.dto;

import lombok.Data;
import java.util.Date;

@Data
public class StaffDTO {
    private Integer id;
    private String name;
    private Date dateOfBirth;
    private String phone;
}
