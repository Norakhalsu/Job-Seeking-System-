package com.example.job_seeking_system.Controller;


import com.example.job_seeking_system.Api.ApiResponse;
import com.example.job_seeking_system.Model.User;
import com.example.job_seeking_system.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;


    @GetMapping("/get")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@Valid@RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added successfully"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
           if ( userService.UpdateUser(id, user)){
               return ResponseEntity.status(200).body(new ApiResponse("User updated successfully"));
           }
           return ResponseEntity.status(400).body(new ApiResponse("Sorry User Not Found"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){

        if (userService.deleteUser(id)){
        return ResponseEntity.status(200).body(new ApiResponse("User deleted successfully"));
    }
    return ResponseEntity.status(400).body(new ApiResponse("Sorry User Not Found"));
    }





}
