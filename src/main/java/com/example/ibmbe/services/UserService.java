package com.example.ibmbe.services;

import com.example.ibmbe.entities.User;
import com.example.ibmbe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser (final Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public List<User> getUserByTeamId (final Long teamId) {
        return userRepository.findByTeamId(teamId);
    }

    public boolean deleteUserById (Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
