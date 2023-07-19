package com.example.ibmbe.controllers;

import com.example.ibmbe.entities.User;
import com.example.ibmbe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById (@RequestParam final long id) {
        return userService.getUser(id);
    }

    @GetMapping("/{teamId}")
    public List<User> getUserByTeamId (@RequestParam final long teamId) {
        return userService.getUserByTeamId(teamId);
    }

    @GetMapping
    public List<User> getAllUsers () {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById (@RequestParam final long id) {
        boolean deleted = userService.deleteUserById(id);
        if (deleted)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }
}
