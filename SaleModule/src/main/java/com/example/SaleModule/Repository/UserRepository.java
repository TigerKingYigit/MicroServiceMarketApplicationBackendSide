package com.example.SaleModule.Repository;

import java.util.Optional;

import com.example.SaleModule.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
/**
 * to get user from database by email
 * @param email String type of field is user class
 * */
    Optional<User> findByEmail(String email);

}