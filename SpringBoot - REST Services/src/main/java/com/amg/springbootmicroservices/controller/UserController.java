package com.amg.springbootmicroservices.controller;

import com.amg.springbootmicroservices.DTO.UserDto;
import com.amg.springbootmicroservices.entity.User;
import com.amg.springbootmicroservices.exception.ErrorDetails;
import com.amg.springbootmicroservices.exception.ResourceNotFoundException;
import com.amg.springbootmicroservices.service.implemetation.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;


@Tag(
        name = "CRUD REST APIs for user resource",
        description = "CRUD REST APIs - Create user,update user, get user, get all users, delete user"
)
@RestController
@RequestMapping("/users/api/v1")

public class UserController {
    final
    UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Operation(
            summary = "Create User REST API",
            description = "Create user Rest API is used to save in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 created"
    )
    @PostMapping("/create-user")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto)
    {
        userServiceImpl.createUser(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get User By ID REST API",
            description = "Get User By ID REST API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/get-user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
       UserDto userDto = userServiceImpl.getUserById(id);

        return new ResponseEntity<>(userDto,HttpStatus.OK);

    }

    @Operation(
            summary = "Get All Users REST API",
            description = "Get All Users REST API is used to get a all the users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/list-users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userServiceImpl.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a particular user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id,
                                              @RequestBody @Valid  UserDto userDto){
        userDto.setId(id);
        UserDto updateUserDto = userServiceImpl.updateUser(userDto);

        return new ResponseEntity<>(updateUserDto,HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is used to delete a particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userServiceImpl.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);
    }

}
