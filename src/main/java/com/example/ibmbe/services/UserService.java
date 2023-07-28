package com.example.ibmbe.services;

import com.example.ibmbe.entities.User;
import com.example.ibmbe.exceptions.NoUserFoundByTeamException;
import com.example.ibmbe.exceptions.NoUserFoundException;
import com.example.ibmbe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser (final Long id) {
        Optional<User> userOptional =  userRepository.findById(id);
        return userOptional.orElseThrow(() -> new NoUserFoundException(HttpStatus.NOT_FOUND));
    }

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public List<User> getUserByTeamId (final Long teamId) {
        Optional<List<User>> users = Optional.ofNullable(userRepository.findByTeamId(teamId));
        return users.orElseThrow(() -> new NoUserFoundByTeamException(HttpStatus.NOT_FOUND));
    }

    public boolean deleteUserById (Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        throw(new NoUserFoundException(HttpStatus.NOT_FOUND));
    }
}