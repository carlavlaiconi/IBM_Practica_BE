package com.example.ibmbe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="activity", schema="public")
public class Activity extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;
}
