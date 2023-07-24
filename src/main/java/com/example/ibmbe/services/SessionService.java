package com.example.ibmbe.services;

import com.example.ibmbe.entities.Session;
import com.example.ibmbe.exceptions.CustomException;
import com.example.ibmbe.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> getSessionByActivityId (final Long activityId) {
        Optional<List<Session>> sessionList = Optional.ofNullable(sessionRepository.findByActivityId(activityId));
        return sessionList.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "No sessions found for the activity with id : " + activityId));
    }

    public List<Session> getAllSessions () {
        return sessionRepository.findAll();
    }

    public Session saveSession (final Session session) {
        return sessionRepository.save(session);
    }
}
