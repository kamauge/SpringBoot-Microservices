package com.amg.springbootmicroservices.repository;


import com.amg.springbootmicroservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
