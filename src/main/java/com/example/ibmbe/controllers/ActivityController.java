package com.example.ibmbe.controllers;

import com.example.ibmbe.entities.Activity;
import com.example.ibmbe.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<Activity> getAllActivities () {
        return activityService.getAllActivities();
    }
}