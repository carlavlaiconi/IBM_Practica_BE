package com.example.ibmbe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name="activity", schema="public")
public class Activity extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    public Activity(String name) {
        this.name = name;
    }

    public Activity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                '}';
    }
}
