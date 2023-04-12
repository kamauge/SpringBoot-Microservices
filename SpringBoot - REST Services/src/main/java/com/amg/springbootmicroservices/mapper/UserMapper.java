package com.amg.springbootmicroservices.mapper;


import com.amg.springbootmicroservices.DTO.UserDto;
import com.amg.springbootmicroservices.entity.User;

public class UserMapper {

    public static UserDto mapToUserDTO(User user){

        //Covert User JPA Entity to User DTO
        UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());

        return userDto;

    }

    public static User mapToUser(UserDto userDto){

        //Convert User DTO into User JPA Entity
        User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());

        return user;

    }
}
