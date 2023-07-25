package com.example.ibmbe.services;

import com.example.ibmbe.entities.Grade;
import com.example.ibmbe.exceptions.CustomException;
import com.example.ibmbe.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getGradeByStudentId (final Long studentId) {
        Optional<List<Grade>> grades = Optional.ofNullable(gradeRepository.findByStudentId(studentId));
        return grades.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "No grade with this student id: " + studentId + " found"));
    }

    public List<Grade> getGradeBySessionId (final Long sessionId) {

        Optional<List<Grade>> grades = Optional.ofNullable(gradeRepository.findBySessionId(sessionId));
        return grades.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "No grade with this session id: " + sessionId + " found"));
    }

    public Grade saveGrade (final Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Grade updatedGrade) {
        Optional<Grade> optionalGrade = gradeRepository.findById(updatedGrade.getId());
        optionalGrade.orElseThrow((() -> new RuntimeException("Grade with id: "+ updatedGrade.getId() + " not found")));
        Grade existingGrade = optionalGrade.get();
        existingGrade.setGrade(updatedGrade.getGrade());
        existingGrade.setComment(updatedGrade.getComment());
        return gradeRepository.save(existingGrade);
    }
}