package com.amg.microservices.controller;

import com.amg.microservices.entity.User;
import com.amg.microservices.service.implemetation.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/api/v1")
public class UserController {
    final
    UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        userServiceImpl.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
       User user = userServiceImpl.getUserById(id);

        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @GetMapping("/list-users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userServiceImpl.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        User updateUser = userServiceImpl.updateUser(user);

        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }

    @DeleteMapping("/delete-user/{id")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userServiceImpl.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);
    }
}
