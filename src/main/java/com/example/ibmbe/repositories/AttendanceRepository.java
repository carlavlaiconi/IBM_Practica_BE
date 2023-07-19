package com.example.ibmbe.repositories;

import com.example.ibmbe.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStudentId(Long studentId);
    List<Attendance> findBySessionId(Long sessionId);

}
