package com.example.ibmbe.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="grade", schema = "public")
public class Grade extends BaseEntity{

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "studentId", referencedColumnName = "id", nullable = false)
    private User student;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sessionId", referencedColumnName = "id", nullable = false)
    private Session session;

    @Column(name = "grade", nullable = false)
    private int grade;

    @Column(name = "comment", nullable = true)
    private String comment;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mentorId", referencedColumnName = "id", nullable = false)
    private User mentor;

    public Grade() {
    }

    public Grade(User student, Session session, int grade, String comment, User mentor) {
        this.student = student;
        this.session = session;
        this.grade = grade;
        this.comment = comment;
        this.mentor = mentor;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getMentor() {
        return mentor;
    }

    public void setMentor(User mentor) {
        this.mentor = mentor;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "student=" + student +
                ", session=" + session +
                ", grade=" + grade +
                ", comment='" + comment + '\'' +
                ", mentor=" + mentor +
                '}';
    }
}