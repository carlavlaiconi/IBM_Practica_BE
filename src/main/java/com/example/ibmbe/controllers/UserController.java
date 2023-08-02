package com.example.ibmbe.controllers;

import com.example.ibmbe.entities.User;
import com.example.ibmbe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById (@RequestParam final long id) {
        return userService.getUser(id);
    }

    @GetMapping("/team/{id}")
    public List<User> getUserByTeamId (@RequestParam final long teamId) {
        return userService.getUserByTeamId(teamId);
    }

    @GetMapping
    public List<User> getAllUsers () {
        return userService.getAllUsers();
    }


    @DeleteMapping("/teamId&email/{teamId}{email}")
    public ResponseEntity<Void> deleteUserByTeamIdEmail (@RequestParam final long teamId, @RequestParam final String email) {
        boolean deleted = userService.deleteUserByTeamIdAndEmail(teamId, email);
        if (deleted)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }

}
