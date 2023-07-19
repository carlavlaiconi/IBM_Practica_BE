package com.example.ibmbe.services;

import com.example.ibmbe.entities.Session;
import com.example.ibmbe.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public Session getSessionByActivityId (final Long activityId) {
        return sessionRepository.findByActivityId(activityId);
    }

    public List<Session> getAllSessions () {
        return sessionRepository.findAll();
    }

    public Session saveSession (final Session session) {
        return sessionRepository.save(session);
    }
}
