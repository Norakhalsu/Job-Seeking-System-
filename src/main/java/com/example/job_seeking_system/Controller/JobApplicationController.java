package com.example.job_seeking_system.Controller;


import com.example.job_seeking_system.Api.ApiResponse;
import com.example.job_seeking_system.Model.JobApplication;
import com.example.job_seeking_system.Model.JobPost;
import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Service.JobApplicationService;
import com.example.job_seeking_system.Service.JobPostService;
import com.example.job_seeking_system.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/JobApplication")
public class JobApplicationController {


    private final JobApplicationService jobApplicationService;


    @GetMapping("/get") // Get all Job Applications ,Retrieves a list of all Job Application.
    public ResponseEntity getAllJobApplication(){
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApplications());
    }


    @PostMapping("/apply/{userId}/{jobPostId}")//Apply For Job: Adds a new job application to the system.
    public ResponseEntity ApplyJobApplication(@PathVariable Integer userId , @PathVariable Integer jobPostId, @Valid @RequestBody JobApplication jobApplication, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        String message = jobApplicationService.applyForJob(userId, jobPostId, jobApplication);

      if (message.equalsIgnoreCase("Job application submitted successfully")){
          jobApplicationService.applyForJob(userId,jobPostId,jobApplication);
          return ResponseEntity.status(200).body(new ApiResponse("Job Application Applied successfully"));
      }
      return ResponseEntity.status(400).body(message);
    }



    @DeleteMapping("/Withdraw/{id}/{userId}/{jobId}")//Withdraw Job Application ,Deletes a job application from the system.
    public ResponseEntity deleteJobApplication(@PathVariable Integer id , @PathVariable Integer userId , @PathVariable Integer jobId){

        if (jobApplicationService.withdrawJobApplication(id,userId,jobId)){
            return ResponseEntity.status(200).body(new ApiResponse(" Withdraw Job Application successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Sorry Job Application Not Found"));
    }





//
//    @PutMapping("/update/{id}")
//    public ResponseEntity updateJobApplication(@PathVariable Integer id, @Valid @RequestBody JobApplication jobApp, Errors errors){
//        if(errors.hasErrors()){
//            String message = errors.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(400).body(message);
//        }
//        if ( jobApplicationService.UpdateJobApplication(id, jobApp)){
//            return ResponseEntity.status(200).body(new ApiResponse("Job Application updated successfully"));
//        }
//        return ResponseEntity.status(400).body(new ApiResponse("Sorry Job Application Not Found"));
//    }






}



