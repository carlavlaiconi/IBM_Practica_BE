package com.example.ibmbe.repositories;

import com.example.ibmbe.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByActivityId(Long activityId);
}