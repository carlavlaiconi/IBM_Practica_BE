package com.example.ibmbe.services;

import com.example.ibmbe.entities.Attendance;
import com.example.ibmbe.entities.Grade;
import com.example.ibmbe.exceptions.*;
import com.example.ibmbe.repositories.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAttendanceByStudentId (final Long studentId) {
        Optional<List<Attendance>> attendanceList = Optional.ofNullable(attendanceRepository.findByStudentId(studentId));
        return attendanceList.orElseThrow(() -> new NoAttendanceFoundByStudentException(HttpStatus.NOT_FOUND));
    }

    public List<Attendance> getAttendanceBySessionId (final Long sessionId) {
        Optional<List<Attendance>> attendanceList = Optional.ofNullable(attendanceRepository.findBySessionId(sessionId));
        return attendanceList.orElseThrow(() -> new NoAttendanceFoundBySessionException(HttpStatus.NOT_FOUND));
    }

    public List<Attendance> getAttendanceByStudentIdAndSessionId (final Long studentId, final Long sessionId) {

        Optional<List<Attendance>> attendances = Optional.ofNullable(attendanceRepository.findByStudentIdAndSessionId(studentId, sessionId));
        return attendances.orElseThrow(() -> new NoAttendanceFoundByStudentIdAndSessionIdException(HttpStatus.NOT_FOUND));
    }

    public Attendance saveAttendance (final Attendance attendance) {
        return attendanceRepository.save(attendance);
    }


    public Attendance updateAttendanceByStudentIdAndSessionId(final Long studentId, final Long sessionId) {
        Attendance optionalAttendance = attendanceRepository.findAttendanceByStudentIdAndSessionId(studentId, sessionId);
        Attendance newAttendance = optionalAttendance;
        if(optionalAttendance.isPresent())
            newAttendance.setPresent(false);
        else
            newAttendance.setPresent(true);
        return attendanceRepository.save(newAttendance);
    }

}