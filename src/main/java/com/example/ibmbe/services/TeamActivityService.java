package com.example.ibmbe.services;

import com.example.ibmbe.entities.TeamActivity;
import com.example.ibmbe.repositories.TeamActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamActivityService {
    @Autowired
    private TeamActivityRepository teamActivityRepository;

    public List<TeamActivity> getByTeamId (final Long teamId) {
        return teamActivityRepository.findByTeamId(teamId);
    }

    public List<TeamActivity> getByActivityId (final Long activityId) {
        return teamActivityRepository.findByActivityId(activityId);
    }

    public TeamActivity saveTA (final TeamActivity teamActivity) {
        return teamActivityRepository.save(teamActivity);
    }
}
