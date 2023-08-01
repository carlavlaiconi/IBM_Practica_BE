package com.example.ibmbe.repositories;

import com.example.ibmbe.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findBySessionId(Long sessionId);
    @Query("SELECT g FROM Grade g WHERE g.student.id = :studentId AND g.session.id = :sessionId")
    List<Grade> findByStudentIdAndSessionId(@Param("studentId") Long studentId, @Param("sessionId") Long sessionId);

    @Query("SELECT g FROM Grade g WHERE g.mentor.id = :mentorId AND g.session.id = :sessionId")
    List<Grade> findByMentorIdAndSessionId(@Param("mentorId") Long mentorId, @Param("sessionId") Long sessionId);
    @Query("SELECT g FROM Grade g WHERE g.student.id = :studentId AND g.session.id = :sessionId AND g.mentor.id = :mentorId")
    Grade findByStudentIdSessionIdAndMentorId(@Param("studentId") Long studentId, @Param("sessionId") Long sessionId, @Param("mentorId") Long mentorId);
}
