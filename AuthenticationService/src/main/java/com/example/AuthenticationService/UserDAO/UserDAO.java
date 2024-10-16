package com.example.AuthenticationService.UserDAO;

import com.example.AuthenticationService.Models.Role;
import com.example.AuthenticationService.Models.User;
import com.example.AuthenticationService.Repository.GenericRepository;
import com.example.AuthenticationService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDAO implements IUserDAO, GenericRepository<User> {
    @Autowired
    UserRepository userRepository;
    @Override
    public void Add(User Entity) {
        userRepository.save(Entity);
    }

    @Override
    public void DeleteById(Integer Id) {
        userRepository.deleteById(Id);
    }

    @Override
    public void Update(User Entity) {

    }

    @Override
    public User GetById(Integer Id) {
        User user =  userRepository.getReferenceById(Id);
        System.out.println(user);
        return user;
    }

    @Override
    public List<User> GetList() {
        return null;
    }

    public void updateUserRole(Role role, Integer userId) {
        User user =userRepository.getReferenceById(userId);
        user.setRole(role);
        userRepository.save(user);
    }
}
