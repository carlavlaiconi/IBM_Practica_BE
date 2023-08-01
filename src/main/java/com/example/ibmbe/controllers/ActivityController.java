package com.example.ibmbe.controllers;

import com.example.ibmbe.entities.Activity;
import com.example.ibmbe.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<Activity> getAllActivities () {
        return activityService.getAllActivities();
    }

    @PostMapping
    public Activity createActivity(@RequestBody final Activity activity) {
        return activityService.saveActivity(activity);
    }
}
