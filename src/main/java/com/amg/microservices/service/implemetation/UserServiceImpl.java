package com.amg.microservices.service.implemetation;

import com.amg.microservices.entity.User;
import com.amg.microservices.repository.UserRepository;
import com.amg.microservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    final
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
