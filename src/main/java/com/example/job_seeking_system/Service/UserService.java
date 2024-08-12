package com.example.job_seeking_system.Service;

import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }



    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean UpdateUser(Integer id , User user) {
        User user1=userRepository.getById(id);

        if(user1!=null) {
            user1.setName(user.getName());
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            user1.setAge(user.getAge());
            user1.setRole(user.getRole());
            userRepository.save(user1);
            return true;
        }
        return false;
    }




    public boolean deleteUser(Integer id ) {
        User user1=userRepository.getById(id);
        if(user1!=null) {
            userRepository.delete(user1);
        }
        return true;
    }






}
