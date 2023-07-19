package com.example.ibmbe.services;

import com.example.ibmbe.entities.Attendance;
import com.example.ibmbe.repositories.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAttendanceByStudentId (final Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

    public List<Attendance> getAttendanceBySessionId (final Long sessionId) {
        return attendanceRepository.findBySessionId(sessionId);
    }

    public Attendance saveAttendance (final Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {
        Attendance attendance = attendanceRepository.findById(id).orElse(null);
        if (attendance != null) {
            attendance.setPresent(updatedAttendance.isPresent());
            return attendanceRepository.save(attendance);
        } else {
            return null;
        }
    }
}
