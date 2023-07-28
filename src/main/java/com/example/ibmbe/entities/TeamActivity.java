package com.example.ibmbe.entities;

import jakarta.persistence.*;



@Entity
@Table(name="teamActivity", schema = "public")
public class TeamActivity extends BaseEntity{

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teamId", referencedColumnName = "id", nullable = false)
    private Team team;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "activityId", referencedColumnName = "id", nullable = false)
    private Activity activity;

    public TeamActivity() {
    }

    public TeamActivity(Team team, Activity activity) {
        this.team = team;
        this.activity = activity;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "TeamActivity{" +
                "team=" + team +
                ", activity=" + activity +
                '}';
    }
}