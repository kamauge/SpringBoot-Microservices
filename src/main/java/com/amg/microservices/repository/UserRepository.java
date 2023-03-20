package com.amg.microservices.repository;

import com.amg.microservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface UserRepository extends JpaRepository<User,Long> {
}
