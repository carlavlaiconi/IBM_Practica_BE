package com.example.ibmbe.services;

import com.example.ibmbe.entities.Activity;
import com.example.ibmbe.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivities () {
        return activityRepository.findAll();
    }

    public Activity saveActivity (final Activity activity) {
        return activityRepository.save(activity);
    }
}
