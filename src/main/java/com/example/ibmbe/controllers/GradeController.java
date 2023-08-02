package com.example.ibmbe.controllers;

import com.example.ibmbe.entities.Grade;
import com.example.ibmbe.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/session/{sessionId}")
    public List<Grade> getGradeBySessionId (@RequestParam final long sessionId) {
        return gradeService.getGradeBySessionId(sessionId);
    }

    @GetMapping("/student/{studentId}{sessionId}{activiyId}")
    public List<Grade> getGradeByStudentIdAndSessionIdAndActivityId (@RequestParam final long studentId, @RequestParam final long sessionId, @RequestParam final long activityId) {
        return gradeService.getGradeByStudentIdAndSessionIdAndAcitivityId(studentId, sessionId, activityId);
    }

//    @GetMapping("/activity/{studentId}{activityId}")
//    public List<Grade> getGradeByStudentIdAndACtivityId (@RequestParam final long studentId, @RequestParam final long activityId) {
//        return gradeService.getGradeByStudentIdAndActivityId(studentId, activityId);
//    }

    @GetMapping("/mentor/{mentorId}{sessionId}")
    public List<Grade> getGradeByMentorIdAndSessionId (@RequestParam final long mentorId, @RequestParam final long sessionId) {
        return gradeService.getGradeByMentorIdAndSessionId(mentorId, sessionId);
    }
    @GetMapping("/activity/{studentId}{activityId}{sessionId}")
    public Double getAverageGrade(@PathVariable final long studentId, @PathVariable final long activityId, @PathVariable final long sessionId) {
        return gradeService.getAverageGrade(studentId, activityId, sessionId);
    }
    @GetMapping("/average/{studentId}/{activityId}")
    public Double getAverage(@PathVariable final long studentId, @PathVariable final long activityId) {
        return gradeService.getAverage(studentId, activityId);
    }

    @PostMapping
    public Grade createGrade (@RequestBody final Grade grade) {
        return gradeService.saveGrade(grade);
    }

    @PutMapping("/{studentId}{sessionId}{mentorId}")
    public ResponseEntity<Grade> updateGradeByStudentIdSessionIdAndMentorId(@RequestParam final Long studentId, @RequestParam final Long sessionId, @RequestParam final Long mentorId, @RequestParam final int newGrade, @RequestParam(required = false) final String comment) {
        Grade grade = gradeService.updateGradeByStudentIDSessionIdAndMentorId(studentId, sessionId, mentorId, newGrade, comment);
        if (grade != null) {
            return new ResponseEntity<>(grade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}