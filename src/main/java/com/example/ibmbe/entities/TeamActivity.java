package com.example.ibmbe.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="teamActivity", schema="public")
public class TeamActivity extends BaseEntity{

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teamId", nullable = false)
    private Team team;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "activityId", nullable = false)
    private Activity activity;
}
