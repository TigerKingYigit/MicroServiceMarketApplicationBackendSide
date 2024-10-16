package com.example.ProductModule.DAO.UserDAO;

import com.example.ProductModule.Models.Role;
import com.example.ProductModule.Models.User;
import com.example.ProductModule.Repository.GenericRepository;
import com.example.ProductModule.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO implements IUserDAO {
    @Autowired
    UserRepository userRepository;

    public void Add(User Entity) {
        userRepository.save(Entity);
    }


    public void DeleteById(Integer Id) {
        userRepository.deleteById(Id);
    }


    public void Update(User Entity) {

    }


    public User GetById(Integer Id) {
        return userRepository.getReferenceById(Id);
    }


    public List<User> GetList() {
        return null;
    }

    public void updateUserRole(Role role, Integer userId) {
        User user =userRepository.getReferenceById(userId);
        user.setRole(role);
        userRepository.save(user);
    }
}
