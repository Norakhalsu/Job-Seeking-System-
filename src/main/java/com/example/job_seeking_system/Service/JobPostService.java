package com.example.job_seeking_system.Service;


import com.example.job_seeking_system.Model.JobPost;
import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;



    public List<JobPost> getAllJobs() {
        return jobPostRepository.findAll();
    }



    public void addJob(JobPost jobPost) {
        jobPostRepository.save(jobPost);
    }



    public boolean UpdateJob(Integer id , JobPost jobPost) {
        JobPost j1=jobPostRepository.getById(id);

        if(j1 != null) {
           j1.setTitle(jobPost.getTitle());
           j1.setDescription(jobPost.getDescription());
           j1.setLocation(jobPost.getLocation());
           j1.setSalary(jobPost.getSalary());
           j1.setPostingDate(j1.getPostingDate());
           jobPostRepository.save(j1);
            return true;
        }
        return false;
    }




    public boolean deleteUser(Integer id ) {
        JobPost jobPost=jobPostRepository.getById(id);

        if(jobPost!=null) {
            jobPostRepository.delete(jobPost);
        }
        return true;
    }



}
