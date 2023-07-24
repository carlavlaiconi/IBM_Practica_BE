package com.example.ibmbe.services;

import com.example.ibmbe.entities.Attendance;
import com.example.ibmbe.exceptions.CustomException;
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
        return attendanceList.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "No attendance with this student id : " + studentId + "found."));
    }

    public List<Attendance> getAttendanceBySessionId (final Long sessionId) {
        Optional<List<Attendance>> attendanceList = Optional.ofNullable(attendanceRepository.findByStudentId(sessionId));
        return attendanceList.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "No attendance with this session id : " + sessionId + "found."));
    }

    public Attendance saveAttendance (final Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Attendance updatedAttendance) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(updatedAttendance.getId());
        optionalAttendance.orElseThrow((() -> new RuntimeException("Grade with id: "+ updatedAttendance.getId() + " not found")));
        Attendance existingAttendance = optionalAttendance.get();
        existingAttendance.setPresent(updatedAttendance.isPresent());
        return attendanceRepository.save(existingAttendance);
    }
}