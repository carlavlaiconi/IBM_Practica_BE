package com.example.ibmbe.repositories;

import com.example.ibmbe.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByTeamId(Long teamId);
}
