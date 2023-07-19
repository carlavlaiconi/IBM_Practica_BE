package com.example.ibmbe.repositories;

import com.example.ibmbe.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
