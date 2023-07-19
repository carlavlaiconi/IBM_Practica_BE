package com.example.ibmbe.controllers;

import com.example.ibmbe.entities.Grade;
import com.example.ibmbe.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/{studentId}")
    public List<Grade> getGradeByStudentId (@RequestParam final long studentId) {
        return gradeService.getGradeByStudentId(studentId);
    }

    @GetMapping("/{sessionId}")
    public List<Grade> getGradeBySessionId (@RequestParam final long sessionId) {
        return gradeService.getGradeBySessionId(sessionId);
    }

    @PostMapping
    public Grade createGrade (@RequestBody final Grade grade) {
        return gradeService.saveGrade(grade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @RequestBody Grade updatedGrade) {
        Grade grade = gradeService.updateGrade(id, updatedGrade);
        if (grade != null) {
            return new ResponseEntity<>(grade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
