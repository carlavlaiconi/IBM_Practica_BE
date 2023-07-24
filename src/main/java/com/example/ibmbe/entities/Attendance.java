package com.example.ibmbe.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
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
}