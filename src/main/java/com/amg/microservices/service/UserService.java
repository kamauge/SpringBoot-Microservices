package com.amg.microservices.service;

import com.amg.microservices.entity.User;

public interface UserService {

     User createUser(User user);

     User getUserById(Long id);
}
