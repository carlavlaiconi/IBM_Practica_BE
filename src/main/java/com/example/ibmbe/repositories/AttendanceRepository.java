package com.example.ibmbe.repositories;

import com.example.ibmbe.entities.Attendance;
import com.example.ibmbe.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStudentId(Long studentId);
    List<Attendance> findBySessionId(Long sessionId);
    @Query("SELECT a FROM Attendance a WHERE a.student.id = :studentId AND a.session.id = :sessionId")
    List<Attendance> findByStudentIdAndSessionId(@Param("studentId") Long studentId, @Param("sessionId") Long sessionId);
    @Query("SELECT a FROM Attendance a WHERE a.student.id = :studentId AND a.session.id = :sessionId")
    Attendance findAttendanceByStudentIdAndSessionId(@Param("studentId") Long studentId, @Param("sessionId") Long sessionId);
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Attendance a WHERE a.student.id = :studentId")
    boolean existsByStudentId(Long studentId);

}
