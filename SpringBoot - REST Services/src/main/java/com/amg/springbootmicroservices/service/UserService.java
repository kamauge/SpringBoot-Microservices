package com.amg.springbootmicroservices.service;

import com.amg.springbootmicroservices.DTO.UserDto;
import com.amg.springbootmicroservices.entity.User;

import java.util.List;

public interface UserService {

     UserDto createUser(UserDto userDto);

     UserDto getUserById(Long id);

     List<UserDto> getAllUsers();

     UserDto updateUser(UserDto userDto);

     void deleteUser(Long id);
}
