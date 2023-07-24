package com.example.ibmbe.services;

import com.example.ibmbe.entities.Team;
import com.example.ibmbe.exceptions.CustomException;
import com.example.ibmbe.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team getTeam (final Long id) {
        Optional<Team> teamOptional =  teamRepository.findById(id);
        return teamOptional.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND,"No team with id : " + id + "found."));
    }

    public Team saveTeam (final Team team) {

        return teamRepository.save(team);
    }
}
