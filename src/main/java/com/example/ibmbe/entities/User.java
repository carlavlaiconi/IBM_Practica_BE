package com.example.ibmbe.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users", schema="public")
public class User extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "leader", nullable = false)
    private boolean leader;
    @Column(name = "mentor", nullable = false)
    private boolean mentor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teamId", nullable = true)
    private Team team;
}
