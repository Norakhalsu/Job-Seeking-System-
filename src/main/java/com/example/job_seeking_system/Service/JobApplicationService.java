package com.example.job_seeking_system.Service;


import com.example.job_seeking_system.Model.JobApplication;
import com.example.job_seeking_system.Model.JobPost;
import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Repository.JobApplicationRepository;
import com.example.job_seeking_system.Repository.JobPostRepository;
import com.example.job_seeking_system.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {


    private final JobApplicationRepository jobApplicationRepository;
    private  final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;


    //Get all Job Applications: Retrieves a list of all Job Application.
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }


   //Apply For Job: Adds a new job application to the system.
    public String applyForJob( Integer userId ,Integer jobPostId ,JobApplication jobApplication ) {

        User user = userRepository.getById(userId);
        JobPost jobPost = jobPostRepository.getById(jobPostId);

        if (user != null && jobPost != null) {
            jobApplicationRepository.save(jobApplication);
            return "Job application submitted successfully";
          }
        else {
            return "Sorry, user or job post not found";
        }
    }


     //Withdraw Job Application: Deletes a job application from the system.
     public boolean withdrawJobApplication(Integer id , Integer userId , Integer JobId ) {
        User user = userRepository.getById(userId);
        JobPost job = jobPostRepository.getById(JobId);
        JobApplication jobApplication = jobApplicationRepository.getById(id);

        if (user != null && job != null && jobApplication != null) {
            jobApplicationRepository.delete(jobApplication);
            return true;
        }
        else {
            return false;
        }

    }




//    public boolean UpdateJobApplication(Integer id , JobApplication jobApplication) {
//       JobApplication JobApp1=jobApplicationRepository.getById(id);
//
//        if(JobApp1!=null) {
//            JobApp1.setJobPostId(jobApplication.getJobPostId());
//            JobApp1.setUserId(jobApplication.getUserId());
//
//            jobApplicationRepository.save(JobApp1);
//            return true;
//        }
//        return false;
//    }









}
