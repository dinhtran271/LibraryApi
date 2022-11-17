package com.dinhtv.LibraryManagement.models.dto;

import lombok.*;

@Data
public class BookDTO {
    private Integer id;
    private String name;
    private String author;
    private String category;
    private String yearOfPublication;
    private Float price;
    private Integer readerId;
    private Integer publisherId;
    private Integer staffId;
}
