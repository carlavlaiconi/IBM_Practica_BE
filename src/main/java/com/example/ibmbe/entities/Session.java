package com.example.ibmbe.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="session", schema = "public")
public class Session extends BaseEntity{

    @Column(name = "date", nullable = false)
    private String date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "activityId", referencedColumnName = "id", nullable = false)
    private Activity activity;

    public Session() {
    }

    public Session(String date, Activity activity) {
        this.date = date;
        this.activity = activity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Session{" +
                "date='" + date + '\'' +
                ", activity=" + activity +
                '}';
    }
}