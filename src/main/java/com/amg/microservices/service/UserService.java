package com.amg.microservices.service;

import com.amg.microservices.DTO.UserDto;
import com.amg.microservices.entity.User;

import java.util.List;

public interface UserService {

     UserDto createUser(UserDto userDto);

     UserDto getUserById(Long id);

     List<UserDto> getAllUsers();

     UserDto updateUser(UserDto userDto);

     void deleteUser(Long id);
}
