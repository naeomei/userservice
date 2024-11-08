package com.vazquez.capstone.userservice.repository;

import com.vazquez.capstone.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); //  authentication
}

