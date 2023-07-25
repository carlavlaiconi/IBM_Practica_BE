package com.example.ibmbe.services;

import com.example.ibmbe.entities.TeamActivity;
import com.example.ibmbe.exceptions.CustomException;
import com.example.ibmbe.repositories.TeamActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamActivityService {
    @Autowired
    private TeamActivityRepository teamActivityRepository;

    public List<TeamActivity> getByTeamId (final Long teamId) {
        Optional<List<TeamActivity>> teamActivityList = Optional.ofNullable(teamActivityRepository.findByTeamId(teamId));
        return teamActivityList.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "No activities found for the team with id: " + teamId));
    }

    public List<TeamActivity> getByActivityId (final Long activityId) {
        Optional<List<TeamActivity>> teamActivityList = Optional.ofNullable(teamActivityRepository.findByActivityId(activityId));
        return teamActivityList.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "No teams found for the activity with id: " + activityId));
    }

    public TeamActivity saveTA (final TeamActivity teamActivity) {
        return teamActivityRepository.save(teamActivity);
    }
}
