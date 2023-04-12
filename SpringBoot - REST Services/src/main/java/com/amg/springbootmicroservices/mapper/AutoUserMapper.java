package com.amg.springbootmicroservices.mapper;

import com.amg.springbootmicroservices.DTO.UserDto;
import com.amg.springbootmicroservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    //AutoUserMapper MAPPER = Mappers.getMapper()
    UserDto mapToDto(User user);

    User mapToDto (UserDto userDto);
}
