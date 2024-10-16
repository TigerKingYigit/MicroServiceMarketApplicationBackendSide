package com.example.RaporModule.UserDAO;

import com.example.RaporModule.Models.Role;
import com.example.RaporModule.Models.User;
import com.example.RaporModule.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
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
