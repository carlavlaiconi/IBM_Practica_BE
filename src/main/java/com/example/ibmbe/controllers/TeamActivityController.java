package com.example.ibmbe.controllers;

import com.example.ibmbe.entities.TeamActivity;
import com.example.ibmbe.services.TeamActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teamActivity")
public class TeamActivityController {

    @Autowired
    private TeamActivityService teamActivityService;

    @GetMapping("/{teamId}")
    public List<TeamActivity> getByTeamId (@RequestParam final long teamId) {
        return teamActivityService.getByTeamId(teamId);
    }

    @GetMapping("/{activityId}")
    public List<TeamActivity> getByActivityId (@RequestParam final long activityId) {
        return teamActivityService.getByActivityId(activityId);
    }

    @PostMapping
    public TeamActivity createTA (@RequestBody final TeamActivity teamActivity) {
        return teamActivityService.saveTA(teamActivity);
    }
}
