package com.amg.microservices.service.implemetation;

import com.amg.microservices.DTO.UserDto;
import com.amg.microservices.entity.User;
import com.amg.microservices.repository.UserRepository;
import com.amg.microservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    final
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto createUser(UserDto userDto) {

        //Convert User DTO into User JPA Entity
        User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());


        User savedUser = userRepository.save(user);

        //Covert User JPA Entity to User DTO
        UserDto savedUserDTO = new UserDto(savedUser.getId(), savedUser.getFirstName(), savedUser.getLastName(), savedUser.getEmail());


        return savedUserDTO;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);

        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
