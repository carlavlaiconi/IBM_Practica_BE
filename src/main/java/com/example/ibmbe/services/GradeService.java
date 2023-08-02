package com.example.ibmbe.services;

import com.example.ibmbe.entities.Grade;
import com.example.ibmbe.entities.Session;
import com.example.ibmbe.exceptions.NoGradeFoundByMentorIdAndSessionIdException;
import com.example.ibmbe.exceptions.NoGradeFoundBySessionException;
import com.example.ibmbe.exceptions.NoGradeFoundByStudentException;
import com.example.ibmbe.exceptions.NoGradeFoundByStudentIdAndSessionIdException;
import com.example.ibmbe.repositories.GradeRepository;
import com.example.ibmbe.repositories.SessionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private SessionRepository sessionRepository;

    public List<Grade> getGradeBySessionId (final Long sessionId) {

        Optional<List<Grade>> grades = Optional.ofNullable(gradeRepository.findBySessionId(sessionId));
        return grades.orElseThrow(() -> new NoGradeFoundBySessionException(HttpStatus.NOT_FOUND));
    }

    public List<Grade> getGradeByStudentIdAndSessionIdAndAcitivityId (final Long studentId, final Long sessionId, final Long activityId) {

        Optional<List<Grade>> grades = Optional.ofNullable(gradeRepository.findByStudentIdAndSessionIdAndActivityId(studentId, sessionId, activityId));
        return grades.orElseThrow(() -> new NoGradeFoundByStudentIdAndSessionIdException(HttpStatus.NOT_FOUND));
    }

    public List<Grade> getGradeByMentorIdAndSessionId (final Long mentorId, final Long sessionId) {

        Optional<List<Grade>> grades = Optional.ofNullable(gradeRepository.findByMentorIdAndSessionId(mentorId, sessionId));
        return grades.orElseThrow(() -> new NoGradeFoundByMentorIdAndSessionIdException(HttpStatus.NOT_FOUND));
    }

    public List<Grade> getGradeByStudentIdAndActivityId (final Long studentId, final Long activityId) {

        Optional<List<Grade>> grades = Optional.ofNullable(gradeRepository.findByStudentIdAndActivityId(studentId, activityId));
        return grades.orElseThrow(() -> new NoGradeFoundByMentorIdAndSessionIdException(HttpStatus.NOT_FOUND));
    }
    public Double getAverageGrade (final Long studentId, final Long activityId, final Long sessionId) {
        Double grade = gradeRepository.findAverage(studentId, activityId, sessionId);
        return grade != null ? grade : 0.0;
    }
    public Double getAverage (final Long studentId, final Long activityId) {
        List<Session> sessions =  sessionRepository.findByActivityId(activityId);
        Double average = 0.0;
        int k=0;
        for (Session session: sessions) {
            Long sessionId = session.getId();
            Double grade = gradeRepository.findAverage(studentId, activityId, sessionId);
            average += grade;
            k++;
        }
        if (k!=0)
            return average/k;
        return 0.0;
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