package com.amg.springbootmicroservices.service.implemetation;

import com.amg.springbootmicroservices.DTO.UserDto;
import com.amg.springbootmicroservices.entity.User;
import com.amg.springbootmicroservices.mapper.UserMapper;
import com.amg.springbootmicroservices.repository.UserRepository;
import com.amg.springbootmicroservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    final
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        //Convert User DTO into User JPA Entity
       // User user = UserMapper.mapToUser(userDto);
        User user = modelMapper.map(userDto,User.class);


        User savedUser = userRepository.save(user);

        //Covert User JPA Entity to User DTO
       // UserDto savedUserDTO = UserMapper.mapToUserDTO(savedUser);

        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public UserDto getUserById(Long id) {
        //Convert User JPA Entity to DTO
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();

       // return UserMapper.mapToUserDTO(user);
        return modelMapper.map(user,UserDto.class);

    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();

        //Convert JPA Entity to DTO
       // return users.stream().map(UserMapper::mapToUserDTO).collect(Collectors.toList());
        return users.stream().map((user -> modelMapper.map(user,UserDto.class))).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        //Convert UserDTO to User JPA Entity
       // User user = UserMapper.mapToUser(userDto);
        User user = modelMapper.map(userDto,User.class);
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);

       // return UserMapper.mapToUserDTO(updatedUser);
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
