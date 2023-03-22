package com.amg.microservices.service;

import com.amg.microservices.DTO.UserDto;
import com.amg.microservices.entity.User;

import java.util.List;

public interface UserService {

     UserDto createUser(UserDto userDto);

     User getUserById(Long id);

     List<User> getAllUsers();

     User updateUser(User user);

     void deleteUser(Long id);
}
