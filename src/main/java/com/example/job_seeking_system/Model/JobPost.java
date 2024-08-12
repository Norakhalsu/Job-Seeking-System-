package com.example.job_seeking_system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title must be not empty ")
    @Size(min = 5,message = "Title length must be more than 4 characters ")
    @Column(columnDefinition = "varchar(15) UNIQUE NOT NULL ")
    private String title;

    @NotEmpty(message = "Description cannot be null")
    @Column(columnDefinition = "varchar(60) NOT NULL ")
    private String description;

    @NotEmpty(message = "Location Cannot be empty ")
    @Column(columnDefinition = "varchar(20) UNIQUE NOT NULL ")
    private String location;

    @NotNull(message = "Salary cannot ba null")
    @Min(value = 0, message = "Salary must be a non-negative number")
    @Column(columnDefinition = "double NOT NULL ")
    private double salary;

    @Column(columnDefinition = "datetime ")
    private LocalDate  postingDate ;

}
