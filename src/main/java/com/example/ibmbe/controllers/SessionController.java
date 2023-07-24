package com.example.ibmbe.controllers;

import com.example.ibmbe.entities.Session;
import com.example.ibmbe.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/{activityId}")
    public Session getSessionByActivityId (@RequestParam final Long activityId) {
        return sessionService.getSessionByActivityId(activityId);
    }

    @GetMapping
    public List<Session> getAllSessions () {
        return sessionService.getAllSessions();
    }

    @PostMapping
    public Session createSession(@RequestBody final Session session) {
        return sessionService.saveSession(session);
    }
}