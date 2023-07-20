package com.example.ibmbe.entities;

import com.example.ibmbe.Role;
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
    @Column(name = "role", nullable = false)
    private Role role;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teamId", nullable = true)
    private Team team;
}
