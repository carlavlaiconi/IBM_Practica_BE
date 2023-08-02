package com.example.ibmbe.services;

import com.example.ibmbe.entities.Session;
import com.example.ibmbe.entities.Team;
import com.example.ibmbe.entities.User;
import com.example.ibmbe.exceptions.NoTeamFoundException;
import com.example.ibmbe.repositories.TeamRepository;
import com.example.ibmbe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GradeService gradeService;

    public Team getTeam (final Long id) {
        Optional<Team> teamOptional =  teamRepository.findById(id);
        return teamOptional.orElseThrow(() -> new NoTeamFoundException(HttpStatus.NOT_FOUND));
    }
    public Double getTeamAverage (final Long id, final Long activityId) {
        List<User> users =  userRepository.findByTeamId(id);
        Double average = 0.0;
        int k=0;
        for (User user: users) {
            Double grade = gradeService.getAverage(user.getId(), activityId);
            average += grade;
            k++;
        }
        if (k!=0)
            return average/k;
        return 0.0;
    }

    public Team saveTeam (final Team team) {
        return teamRepository.save(team);
    }
}
