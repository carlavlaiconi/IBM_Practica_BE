package com.example.ibmbe.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users", schema = "public")
public class User extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "role", nullable = false)
    private String role;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teamId", referencedColumnName = "id", nullable = true)
    private Team team;
}