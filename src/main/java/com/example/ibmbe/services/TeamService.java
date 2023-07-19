package com.example.ibmbe.services;

import com.example.ibmbe.entities.Team;
import com.example.ibmbe.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team getTeam (final Long id) {
        return teamRepository.findById(id).get();
    }

    public Team saveTeam (final Team team) {
        return teamRepository.save(team);
    }
}
