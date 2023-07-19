package com.example.ibmbe.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="session", schema="public")
public class Session extends BaseEntity{

    @Column(name = "date", nullable = false)
    private String date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "activityId", nullable = false)
    private Activity activity;
}