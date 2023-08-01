package com.example.ibmbe.services;

import com.example.ibmbe.entities.Grade;
import com.example.ibmbe.exceptions.NoGradeFoundByMentorIdAndSessionIdException;
import com.example.ibmbe.exceptions.NoGradeFoundBySessionException;
import com.example.ibmbe.exceptions.NoGradeFoundByStudentException;
import com.example.ibmbe.exceptions.NoGradeFoundByStudentIdAndSessionIdException;
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

    public List<Grade> getGradeBySessionId (final Long sessionId) {

        Optional<List<Grade>> grades = Optional.ofNullable(gradeRepository.findBySessionId(sessionId));
        return grades.orElseThrow(() -> new NoGradeFoundBySessionException(HttpStatus.NOT_FOUND));
    }

    public List<Grade> getGradeByStudentIdAndSessionId (final Long studentId, final Long sessionId) {

        Optional<List<Grade>> grades = Optional.ofNullable(gradeRepository.findByStudentIdAndSessionId(studentId, sessionId));
        return grades.orElseThrow(() -> new NoGradeFoundByStudentIdAndSessionIdException(HttpStatus.NOT_FOUND));
    }

    public List<Grade> getGradeByMentorIdAndSessionId (final Long mentorId, final Long sessionId) {

        Optional<List<Grade>> grades = Optional.ofNullable(gradeRepository.findByMentorIdAndSessionId(mentorId, sessionId));
        return grades.orElseThrow(() -> new NoGradeFoundByMentorIdAndSessionIdException(HttpStatus.NOT_FOUND));
    }

    public Grade saveGrade (final Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGradeByStudentIDSessionIdAndMentorId(final Long studentId, final Long sessionId, final Long mentorId, final int grade, final String comment) {
        Grade optionalGrade = gradeRepository.findByStudentIdSessionIdAndMentorId(studentId, sessionId, mentorId);
        Grade newGrade = optionalGrade;
        newGrade.setGrade(grade);
        newGrade.setComment(comment);
        return gradeRepository.save(newGrade);
    }
}