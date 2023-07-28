package com.example.ibmbe.entities;

import jakarta.persistence.*;


@Entity
@Table(name="attendance", schema = "public")
public class Attendance extends BaseEntity{

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "studentId", referencedColumnName = "id", nullable = false)
    private User student;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sessionId", referencedColumnName = "id", nullable = false)
    private Session session;

    @Column(name = "present", nullable = false)
    private boolean present;

    public Attendance() {
    }

    public Attendance(User student, Session session, boolean present) {
        this.student = student;
        this.session = session;
        this.present = present;
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

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "student=" + student +
                ", session=" + session +
                ", present=" + present +
                '}';
    }
}