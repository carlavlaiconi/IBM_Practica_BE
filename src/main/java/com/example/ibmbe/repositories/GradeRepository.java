package com.example.ibmbe.repositories;

import com.example.ibmbe.entities.Grade;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findBySessionId(Long sessionId);
    @Query("SELECT g FROM Grade g WHERE g.student.id = :studentId AND g.session.id = :sessionId AND g.activity.id = :activityId")
    List<Grade> findByStudentIdAndSessionIdAndActivityId(@Param("studentId") Long studentId, @Param("sessionId") Long sessionId, @Param("activityId") Long activityId);

    @Query("SELECT g FROM Grade g WHERE g.mentor.id = :mentorId AND g.session.id = :sessionId")
    List<Grade> findByMentorIdAndSessionId(@Param("mentorId") Long mentorId, @Param("sessionId") Long sessionId);

    @Query("SELECT AVG(g.grade) FROM Grade g WHERE g.student.id = :studentId AND g.activity.id = :activityId AND g.session.id = :sessionId")
    Double findAverage(@Param("studentId") Long studentId, @Param("activityId") Long activityId, @Param("sessionId") Long sessionId);

    @Query("SELECT g FROM Grade g WHERE g.student.id = :studentId AND g.activity.id = :activityId")
    List<Grade> findByStudentIdAndActivityId(@Param("studentId") Long studentId, @Param("activityId") Long activityId);

    @Query("SELECT g FROM Grade g WHERE g.student.id = :studentId AND g.session.id = :sessionId AND g.mentor.id = :mentorId")
    Grade findByStudentIdSessionIdAndMentorId(@Param("studentId") Long studentId, @Param("sessionId") Long sessionId, @Param("mentorId") Long mentorId);
}
