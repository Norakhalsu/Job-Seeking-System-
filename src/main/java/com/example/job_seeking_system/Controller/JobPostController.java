package com.example.job_seeking_system.Controller;


import com.example.job_seeking_system.Api.ApiResponse;
import com.example.job_seeking_system.Model.JobPost;
import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jobpost")
public class JobPostController {

    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getAllJobs(){
        return ResponseEntity.status(200).body(jobPostService.getAllJobs());
    }


    @PostMapping("/add")
    public ResponseEntity addJob(@Valid @RequestBody JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobPostService.addJob(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("Job added successfully"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody JobPost job, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if ( jobPostService.UpdateJob(id, job)){
            return ResponseEntity.status(200).body(new ApiResponse("Job updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Sorry Job Not Found"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){

        if (jobPostService.deleteUser(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Job deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Sorry Job Not Found"));
    }

}
