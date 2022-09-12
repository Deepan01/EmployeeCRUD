package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Employee")
public class Employee {
    @Id
    private int id;
    private String empFirstName;
    private String empLastName;
    private String empEmail;
    private String empDesignation;
    private int empAge;
    private long empSalary;

}
