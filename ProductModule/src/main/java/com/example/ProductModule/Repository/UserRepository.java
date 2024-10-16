package com.example.ProductModule.Repository;


import com.example.ProductModule.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
/**
 * to get user from database by email
 * @param email String type of field is user class
 * */
    Optional<User> findByEmail(String email);

}