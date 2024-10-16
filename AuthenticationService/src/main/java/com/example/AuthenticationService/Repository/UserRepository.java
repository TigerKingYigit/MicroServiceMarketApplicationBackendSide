package com.example.AuthenticationService.Repository;


import com.example.AuthenticationService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
/**
 * to get user from database by email
 * @param email String type of field is user class
 * */
    Optional<User> findByEmail(String email);

}