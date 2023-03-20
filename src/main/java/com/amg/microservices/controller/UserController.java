package com.amg.microservices.controller;

import com.amg.microservices.entity.User;
import com.amg.microservices.service.implemetation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
