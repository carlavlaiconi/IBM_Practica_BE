package com.example.ibmbe.repositories;

import com.example.ibmbe.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Session findByActivityId(Long activityId);
}
