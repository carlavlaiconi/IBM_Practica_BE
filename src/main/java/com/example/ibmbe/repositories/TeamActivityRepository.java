package com.example.ibmbe.repositories;

import com.example.ibmbe.entities.TeamActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamActivityRepository extends JpaRepository<TeamActivity, Long> {
    List<TeamActivity> findByActivityId (Long activityId);
    List<TeamActivity> findByTeamId (Long teamId);

}
