package com.amg.springbootmicroservices.controller;

import com.amg.springbootmicroservices.DTO.UserDto;
import com.amg.springbootmicroservices.entity.User;
import com.amg.springbootmicroservices.exception.ErrorDetails;
import com.amg.springbootmicroservices.exception.ResourceNotFoundException;
import com.amg.springbootmicroservices.service.implemetation.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
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
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
    {
        userServiceImpl.createUser(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
       UserDto userDto = userServiceImpl.getUserById(id);

        return new ResponseEntity<>(userDto,HttpStatus.OK);

    }

    @GetMapping("/list-users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userServiceImpl.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        userDto.setId(id);
        UserDto updateUserDto = userServiceImpl.updateUser(userDto);

        return new ResponseEntity<>(updateUserDto,HttpStatus.OK);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userServiceImpl.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);
    }


//    @ExceptionHandler(ResourceNotFoundException.class) //handle specific exceptions, specific to the controller
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
//                                                                        WebRequest webRequest){
//
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                "USER_NOT_FOUND",
//                resourceNotFoundException.getMessage(),
//                webRequest.getDescription(false));
//
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//
//    }
}
