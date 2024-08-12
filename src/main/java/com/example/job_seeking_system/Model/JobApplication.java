package com.example.job_seeking_system.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "User id cannot be null")
    @Column(columnDefinition = "int NOT NULL ")
    private Integer userId;

    @NotNull(message = "Job Post id cannot be null")
    @Column(columnDefinition = "int NOT NULL")
    private Integer jobPostId;


}
