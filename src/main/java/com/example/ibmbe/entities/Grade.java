package com.example.ibmbe.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="grade", schema="public")
public class Grade extends BaseEntity{

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "studentId", nullable = false)
    private User student;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sessionId", nullable = false)
    private Session session;

    @Column(name = "grade", nullable = false)
    private int grade;

    @Column(name = "comment", nullable = true)
    private String comment;
}

