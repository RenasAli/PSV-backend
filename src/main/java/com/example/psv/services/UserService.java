package com.example.psv.services;

import com.example.psv.model.User;
import com.example.psv.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User saveUser (User user){
        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    public Optional<User> getUserByUsername(String username) {

        return userRepository.findByUserName(username);
    }

    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }


}
