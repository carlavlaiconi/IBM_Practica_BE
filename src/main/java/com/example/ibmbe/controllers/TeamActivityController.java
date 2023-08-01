package com.example.ibmbe.controllers;

import com.example.ibmbe.entities.TeamActivity;
import com.example.ibmbe.services.TeamActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teamActivity")
public class TeamActivityController {

    @Autowired
    private TeamActivityService teamActivityService;

    @GetMapping("/team/{teamId}")
    public List<TeamActivity> getByTeamId (@RequestParam final long teamId) {
        return teamActivityService.getByTeamId(teamId);
    }

    @GetMapping("/activity/{activityId}")
    public List<TeamActivity> getByActivityId (@RequestParam final long activityId) {
        return teamActivityService.getByActivityId(activityId);
    }

    @PostMapping
    public TeamActivity createTA (@RequestBody final TeamActivity teamActivity) {
        return teamActivityService.saveTA(teamActivity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeamActivityById (@RequestParam final long id) {
        boolean deleted = teamActivityService.deleteTeamActivityById(id);
        if (deleted)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }
}