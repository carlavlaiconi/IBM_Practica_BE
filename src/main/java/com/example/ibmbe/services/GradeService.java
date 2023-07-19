package com.example.ibmbe.services;

import com.example.ibmbe.entities.Grade;
import com.example.ibmbe.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getGradeByStudentId (final Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    public List<Grade> getGradeBySessionId (final Long sessionId) {
        return gradeRepository.findBySessionId(sessionId);
    }

    public Grade saveGrade (final Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Long id, Grade updatedGrade) {
        Grade grade = gradeRepository.findById(id).orElse(null);
        if (grade != null) {
            grade.setGrade(updatedGrade.getGrade());
            grade.setComment(updatedGrade.getComment());
            return gradeRepository.save(grade);
        } else {
            return null;
        }
    }
}
