package com.learnspringboot.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // This annotation is used to mark the class as a JPA entity
@Data // This annotation is used to generate getters and setters
@AllArgsConstructor // This annotation is used to generate a constructor with all the fields
@NoArgsConstructor // This annotation is used to generate a default constructor
@ToString // This annotation is used to generate a toString method
public class Phone {
    @Id // This annotation is used to mark the field as a primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // This annotation is used to generate a unique value for the field
    private Integer id;
    private String brand;
    private String model;
    private int noOfCameras;
    private double price;
}
