package com.dinhtv.LibraryManagement.models.dto;

import com.dinhtv.LibraryManagement.models.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class ReaderDTO {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private Integer staffId;
}
