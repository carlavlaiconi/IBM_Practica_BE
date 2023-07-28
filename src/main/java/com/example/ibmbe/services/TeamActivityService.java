package com.example.ibmbe.services;

import com.example.ibmbe.entities.TeamActivity;
import com.example.ibmbe.exceptions.NoActivityFoundByTeamException;
import com.example.ibmbe.exceptions.NoTeamFoundByActivityException;
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
        return teamActivityList.orElseThrow(() -> new NoActivityFoundByTeamException(HttpStatus.NOT_FOUND));
    }

    public List<TeamActivity> getByActivityId (final Long activityId) {
        Optional<List<TeamActivity>> teamActivityList = Optional.ofNullable(teamActivityRepository.findByActivityId(activityId));
        return teamActivityList.orElseThrow(() -> new NoTeamFoundByActivityException(HttpStatus.NOT_FOUND));
    }

    public TeamActivity saveTA (final TeamActivity teamActivity) {
        return teamActivityRepository.save(teamActivity);
    }
}
