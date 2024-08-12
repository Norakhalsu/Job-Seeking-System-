package com.example.job_seeking_system.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotEmpty(message = " Name cannot be empty ")
    @Size(min = 5 ,max = 15, message = " name length must be 5-15 characters")
    @Pattern(regexp = "^[a-zA-Z]+$" , message = " Name Must contain only characters (no numbers).")
    @Column(columnDefinition = "varchar(15) NOT NULL ")
    private String name ;

    @Email(message = " Email must be a valid Format ")
    @Size(max = 25 , message = "email length must be 20 characters max")
    @Column(columnDefinition = "varchar(25) UNIQUE")
    private String email ;

    @NotEmpty(message = "Password cannot be empty ")
    @Column(columnDefinition = "varchar(20) UNIQUE NOT NULL ")
    private String password ;

    @NotNull(message = "Age cannot be null ")
    @Min(value = 22 , message = " Age must be more than 21 ")
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Age must be a number")
    @Column(columnDefinition = "int NOT NULL")
    private int age;

    @NotEmpty(message = "Role cannot be empty")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$", message = "Role must be either 'JOB_SEEKER' or 'EMPLOYER'")
    //@Column(columnDefinition = "varchar(10) NOT NULL CHECK(role='JOB_SEEKER' or role ='EMPLOYER' ) ")
    private String role;


}
