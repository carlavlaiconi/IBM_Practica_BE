package com.example.ibmbe.controllers;

import com.example.ibmbe.entities.Team;
import com.example.ibmbe.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/{id}")
    public Team getTeamById (@RequestParam final long id) {
        return teamService.getTeam(id);
    }

    @PostMapping
    public Team createTeam(@RequestBody final Team team) {
        return teamService.saveTeam(team);
    }
}
